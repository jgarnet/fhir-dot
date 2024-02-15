# FHIR Dot Documentation

The `fhirdot` package contains classes which allow for data elements to be extracted from FHIR structures using a dot-notation-like syntax.

## Syntax and Usage

Data elements can be extracted from a FHIR structure using a dot-notation-like syntax:

```java
PathReader reader = new BasePathReader();
String adjudicationValue = reader.read(bundle, "$ClaimResponse.item.0.adjudication.value");
```

### Nodes

Node types include:

#### Field

Contains a simple field name (i.e. `Object.field`)

```text
Object {
    field: 'test'
}

Object.field -> 'test'
```

#### Collection Item

Specifies an index to retrieve from a collection (i.e. `Object.collection.0`)

```text
Object {
    collection: [
        'test1',
        'test2',
        'test3'
    ]
}

Object.collection.1 -> 'test2'
```

#### Collection

Maps all items in the collection to the given field (i.e. `Object.collection.mappedField`)

```text
Object {
    collection: [
        { id: '1', value: 'test1' },
        { id: '2', value: 'test2' },
        { id: '3', value: 'test3' },
    ]
}

Object.collection.value -> ['test1', 'test2', 'test3']
```

#### Condition

Returns all items in a collection which match a set of conditions.

```text
Object {
    collection: [
        { id: '1', value: 'test1' },
        { id: '2', value: 'test2' },
        { id: '3', value: 'test3' },
    ]
}

Object.collection{id>1} -> [ { id: '2', value: 'test2' }, { id: '3', value: 'test3' } ]
``` 

### Conditions

Conditions are used to filter items in a collection.

Conditions can be defined using the following syntax:

```text
field{condition}
field{condition1&&condition2&&condition3...}
field{condition1||condition2||condition3...}
field{has(nestedCollectionCondition)}
```

The `&&` operation defines that **all** conditions on a node must be met.<br />
The `||` operation defines that **any (at least one)** conditions on a node must be met.

Currently, a node can contain conditions using **only** one operation (i.e. any **OR** all -- **not** both).

Conditional nodes will always return a collection of items which match the conditions; if only one item matches, the return value will be a singleton collection containing that item.

```text
Object {
    field: [
        { id: 1, ... },
        { id: 2, ... },
        { id: 3, ... }
    ]
}

Object.field{id=1} -> [{ id: 1, ... }]
```

Conditions can be evaluated using the following operators:

- =
- !=
- %=
  - checks that a value follows a regex pattern
- !%=
  - checks that a value does **not** follow a regex pattern
- \>
- \<
- \>=
- \<=

In instances where a given data element contains nested collections, the `has` keyword can be used to ensure at least one item from a given nested collection matches a set of conditions.

```text
Object {
    field: [
        {
            nestedField: [
                {
                    url: 'testExtension'
                }
            ]
        }
    ]
}

Object.field{has(nestedField.url%=testExtension)} -> [ { field: [ { nestedField: ... } ] } ]
```

The `has` keyword can be combined with other conditions using the `any` / `all` operations.

```text
Object.collection{has(nested.field.value>1)&&id!=test}
```

<font color="#a83232">**Note:**</font> For performance reasons, the `has` keyword can (currently) only be used to evaluate nested items at the **first** nest-level.

### Aliases

Aliases are provided for ease of use.

- Bundle Resource `$Resource -> entry{resource.resourceType=Resource}.0.resource`
- Bundle Resource with Conditions `$Resource{condition=1} -> entry{resource.resourceType=Resource&&condition=1}.0.resource`
- Extension `extension(someUrl) -> extension{url=someUrl}`
- Extension with Conditions `extension(someUrl){condition1=test} -> extension{url=someUrl&&condition1=test}`
- Extension value cast `extension(url).valueX -> extension(url).value, extension.valueX -> extension.value, etc.`
- Contained Resource `contained(Resource) -> contained{resourceType=Resource}`
- Contained Resource with Conditions `contained(Resource){condition=1} -> contained{resourceType=Resource&&condition=1}`

## Package Structure

### dictionaries

Contains field definitions for all FHIR structures for each FHIR specification (DSTU3, R4, R5, etc.). This layer allows the FHIR specification to be abstracted so that data elements can be extracted and processed in a version-agnostic way.

Provides the `Dictionary` interface which contains mappings for each FHIR structure and determines how each data element on a given FHIR structure should be retrieved.

`Dictionary` leverages an internal map which follows the structure:

```text
Dictionary {
    Base {
        field: obj -> result
    }
}

Dictionary: master map containing all Base definitions.
Base: a given FHIR structure (Types, Elements, Resources)
field: a data element on a given FHIR structure
obj -> result: a function which retrieves the desired data element from the FHIR structure

Example mapping:

R4Dictionary {
    ClaimResponse {
        identifier: obj -> ((ClaimResponse) obj).getIdentifier()
    }
}
```

`Dictionary` instances can be retrieved by passing a FHIR structure to the `DictionaryFactory`, which will internally determine the applicable FHIR specification to provide definitions for.

```java
// i.e. given a ClaimResponse
org.hl7.fhir.r4.model.ClaimResponse claimResponse;
// factory creation can be expensive, so instantiation should be done sparingly
DictionaryFactory factory = new DictionaryFactory();
// we can get all defined FHIR structure definitions from the factory for the R4 FHIR specification
Dictionary dictionary = factory.getDictionary(claimResponse);
// and evaluate fields for the FHIR structure
StringType id = dictionary.getPaths(claimResponse).get("id").apply(claimResponse);
```

The `Dictionary` interface is used to register dictionaries with `DictionaryFactory` by specifying the `Base` FHIR structure class the dictionary is associated with.

`AbstractDictionary` provides common functionality which will scan a given package for classes that implement `Definition` and aggregate the results into one Map.

New dictionaries can be added by extending `AbstractDictionary`:

```java

import org.hl7.fhir.r4.model.Base;

public class R4Dictionary extends AbstractDictionary<Base> {
    @Override
    public String getPackage() {
        return "org.fhirdot.dictionaries.r4";
    }
    
    @Override
    public Class<Base> getBaseClass() {
        return Base.class;
    }
}
```

`Definition` providers can be added to the target package while leveraging common functionality provided by `AbstractDefinition`:

```java

import org.hl7.fhir.r4.model.Base;

public class ResourceDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
      this.paths.put("id", arg -> ((Resource) arg).getIdElement());
      // ...
    }
    
    @Override
    public String getName() {
        return "Resource";
    }
}
```

The `initialize()` method is used to provide all paths and their supplier functions, while `getName()` returns the Class name of the FHIR structure.

### readers

Contains extraction logic which will retrieve the desired data-element from a FHIR structure when given a path.

Extraction is done using a `PathReader`.

```java
PathReader reader = new BasePathReader();
String patientFirstName = reader.read(bundle, "$ClaimResponse.patientTarget.name.0.given.0");
```

`PathReader` can be configured using a `Rules` instance which contains common settings.

### cache

Provides cache capabilities to optimize Node evaluation when reading FHIR structures.

Each Node in a path is associated to its parent FHIR structure (via `Object.hashCode()`) and cached.

All Node paths on a given FHIR structure are internally associated to that Object&apos;s `hashCode()`.

Additionally, the entire path at the end of evaluation is cached.

For example, given:

```text
// Patient Object structure:
Patient {
    name: [
        {
            given: ["Test"],
            family: "Test"
        }
    ]
}

PathReader reader = ...;
reader.read(patient, "nameFirstRep.given.0");
reader.read(patient, "nameFirstRep.family");
```

The following cache entries will be stored:

```text
Cache {
    Patient@1.hashCode(): {
        "nameFirstRep": HumanName@1, // nameFirstRep Node
        "nameFirstRep.given.0": StringType@1, // first path result
        "nameFirstRep.family": StringType@2 // second path result
    },
    HumanName@1.hashCode(): {
        "given": ArrayList@1, // given Node
        "family": StringType@2 // family Node
    },
    ArrayList@1.hashCode(): {
        "0": StringType@1 // first item Node
    }
}
```

Using this convention, all Nodes in a path for a given structure are evaluated only once during the lifetime of a PathReader.

Cache implementations include:

- `InMemoryNodeCache`
  - Leverages an in-memory cache when caching Node evaluation results

### evaluators

Contains logic related to evaluating conditions for a node.

- `ConditionEvaluator`
  - used to evaluate conditions for a given path node on a FHIR structure
  - provides common interface for evaluation operations
- `ConditionEvaluators`
  - aggregates and provides all available `ConditionEvaluator` instances

### aliases

Contains common logic for providing aliases.

- `PathAlias`
  - allows short-hand aliases to be substituted in a path
- `PathAliases`
  - aggregates and provides all available `PathAlias` instances

### framework

Contains common framework classes used by all packages.

- `Rules`
  - provides common settings used to extract data elements

### utils

Contains various helper classes.

- `ConditionParser`
  - extracts conditional nodes from a path (i.e. `field{conditions}`)
- `NodeParser`
  - extracts the outermost nodes from a path

### nodes

Abstracts the logic related to processing a given node in a path.

`AbstractNode` provides common logic for retrieving FHIR structure definitions for a given FHIR structure which will be used to evaluate a given node in the path.