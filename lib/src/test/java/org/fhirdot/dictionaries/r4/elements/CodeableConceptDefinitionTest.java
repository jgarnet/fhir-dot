package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CodeableConceptDefinitionTest extends ElementDefinitionTest {
    private final CodeableConceptDefinition codeableConceptDefinitions;
    private final CodeableConcept codeableConcept;

    public CodeableConceptDefinitionTest() {
        this.codeableConceptDefinitions = new CodeableConceptDefinition();
        this.codeableConcept = new CodeableConcept();
        this.codeableConcept.setText("Test Text");
        this.codeableConcept.addCoding().setCode("Test Code");
    }

    @Test
    public void testSuppliesCoding() {
        List<Coding> result = this.evaluate("coding", this.codeableConcept);
        Assertions.assertEquals("Test Code", result.get(0).getCode());
    }

    @Test
    public void testSuppliesCodingFirstRep() {
        Coding result = this.evaluate("codingFirstRep", this.codeableConcept);
        Assertions.assertEquals("Test Code", result.getCode());
    }

    @Test
    public void testSuppliesText() {
        StringType result = this.evaluate("text", this.codeableConcept);
        Assertions.assertEquals("Test Text", result.getValue());
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.codeableConceptDefinitions;
    }
}
