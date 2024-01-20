# FHIR Path Documentation

The `fhirpath` package contains classes which allow for data elements to be extracted from FHIR structures using a dot-notation-like syntax.

## Syntax and Usage

Data elements can be extracted from a FHIR structure using a dot-notation-like syntax:

```java
FhirPathReader reader = new BaseFhirPathReader();
StringType adjudicationValue = reader.read(bundle, "$ClaimResponse.item.0.adjudication.value");
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

<font color="#a83232">**Note:**</font> For performance reasons, the `has` keyword can (currently) only be used to evaluated nested items at the **first** nest-level.

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

Provides the `FhirDictionary` interface which contains mappings for each FHIR structure and determines how each data element on a given FHIR structure should be retrieved.

`FhirDictionary` leverages an internal map which follows the structure:

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

`FhirDictionary` instances can be retrieved by passing a FHIR structure to the `FhirDictionaryFactory`, which will internally determine the applicable FHIR specification to provide definitions for.

```java
// i.e. given a ClaimResponse
org.hl7.fhir.r4.model.ClaimResponse claimResponse;
// factory creation can be expensive, so instantiation should be done sparingly
FhirDictionaryFactory factory = new FhirDictionaryFactory();
// we can get all defined FHIR structure definitions from the factory for the R4 FHIR specification
FhirDictionary dictionary = factory.getDictionary(claimResponse);
// and evaluate fields for the FHIR structure
StringType id = dictionary.getBaseDefinitions(claimResponse).get("id").apply(claimResponse);
```

The `Dictionary` annotation is used to register dictionaries with `FhirDictionaryFactory` by specifying the `Base` FHIR structure class the dictionary is associated with.

### readers

Contains extraction logic which will retrieve the desired data-element from a FHIR structure when given a path.

Extraction is done using a `FhirPathReader`.

```java
FhirPathReader reader = new BaseFhirPathReader();
String patientFirstName = reader.read(bundle, "$ClaimResponse.patientTarget.name.0.given.0");
```

`FhirPathReader` can be configured using a `Rules` instance which contains common settings.

### evaluators

Contains logic related to evaluating conditions for a node.

- ConditionEvaluator
  - provides common interface for evaluation operations
- ConditionEvaluators
  - aggregates and provides all available `ConditionEvaluator` instances

### aliases

Contains common logic for providing aliases.

- PathAliases
  - aggregates and provides all available `PathAlias` instances

### utils

Contains various helper classes.

- ConditionEvaluator
  - used to evaluate conditions for a given path node on a FHIR structure
- PathAlias
  - allows short-hand aliases to be substituted in a path
- Rules
  - provides common settings used to extract data elements
- ConditionParser
  - extracts conditional nodes from a path (i.e. `field{conditions}`)
- NodeParser
  - extracts the outermost nodes from a path

### nodes

Abstracts the logic related to processing a given node in a path.

`AbstractNode` provides common logic for retrieving FHIR structure definitions for a given FHIR structure which will be used to evaluate a given node in the path.