package org.fhirpath.readers;

import org.fhirpath.readers.framework.FhirPathReader;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseFhirPathReaderTest {

    private final FhirPathReader fhirPathReader;
    private final Bundle bundle;

    public BaseFhirPathReaderTest() {
        this.fhirPathReader = new BaseFhirPathReader();
        this.bundle = this.buildBundle();
    }

    /* Node Tests */

    @Test
    public void testExtractsField() {
        try {
            String insurerId = this.fhirPathReader.read(this.bundle, "$ClaimResponse.insurer.resource.id");
            Assertions.assertEquals("Test Organization", insurerId);
        } catch (Exception e) {
            Assertions.fail("Failed to extract field");
        }
    }

    @Test
    public void testConditions() {
        try {
            String patientId = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.identifier{type.codingFirstRep.code=ID}.0.value");
            String patientIdCollectionIndex = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.identifier{type.coding.0.code=ID}.0.value");
            Assertions.assertEquals("Test Patient", patientId);
            Assertions.assertEquals("Test Patient", patientIdCollectionIndex);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate conditions");
        }
    }

    @Test
    public void testConditionDateComparison() {
        try {
            Extension dateExt = this.fhirPathReader.read(this.bundle, "$ClaimResponse.extension{url=someDate&&value>=2024-01-01}.0");
            Assertions.assertNotNull(dateExt);
        } catch (Exception e) {
            Assertions.fail("Failed to compare date in condition");
        }
    }

    @Test
    public void testAllConditions() {
        try {
            String patientIdentifier = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.identifier{type.codingFirstRep.code=ID2&&system=TEST}.0.value");
            Assertions.assertEquals("Test Patient 2", patientIdentifier);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate multiple conditions");
        }
    }

    @Test
    public void testAnyConditions() {
        try {
            String patientIdentifier = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.identifier{type.codingFirstRep.code=NA||system=TEST}.0.value");
            Assertions.assertEquals("Test Patient 2", patientIdentifier);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate multiple conditions");
        }
    }

    @Test
    public void testNestedPathConditions() {
        try {
            Coding patientIdentifier = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.identifier{system=TEST}.0.type.coding{code=ID3}.0");
            Assertions.assertNotNull(patientIdentifier);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate nested path conditions");
        }
    }

    /* Alias Tests */

    @Test
    public void testResourcePathAlias() {
        try {
            String claimResponseId = this.fhirPathReader.read(this.bundle, "$ClaimResponse.id");
            ClaimResponse claimResponse = this.fhirPathReader.read(this.bundle, "$ClaimResponse");
            Assertions.assertEquals("ClaimResponse", claimResponseId);
            Assertions.assertNotNull(claimResponse);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate resource alias path");
        }
    }

    @Test
    public void testExtensionAlias() {
        try {
            String nickname = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(nickname).0.value");
            Assertions.assertEquals("Fake", nickname);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate extension alias path");
        }
    }

    @Test
    public void testExtensionValueCastAlias() {
        try {
            String nickname = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(nickname).0.valueString");
            String coverageType = this.fhirPathReader.read(this.bundle, "$ClaimResponse.contained(Coverage).0.extension(type).0.valueCodeableConcept.coding.0.code");
            Assertions.assertEquals("Fake", nickname);
            Assertions.assertEquals("Test Type", coverageType);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate extension value cast path");
        }
    }

    @Test
    public void testConditionalExtensionAlias() {
        try {
            String nickname = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(nickname){value=Fake2}.0.value");
            Assertions.assertEquals("Fake2", nickname);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate conditional extension alias path");
        }
    }

    @Test
    public void testContainedResourceAlias() {
        try {
            String subscriberId = this.fhirPathReader.read(this.bundle, "$ClaimResponse.contained(Coverage).0.subscriberId");
            Assertions.assertEquals("Subscriber ID", subscriberId);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate contained resource alias path");
        }
    }

    @Test
    public void testConditionalContainedResourceAlias() {
        try {
            String subscriberId = this.fhirPathReader.read(this.bundle, "$ClaimResponse.contained(Coverage){subscriberId=Subscriber ID}.0.subscriberId");
            Assertions.assertEquals("Subscriber ID", subscriberId);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate conditional contained resource alias path");
        }
    }

    /* Evaluator Tests */

    @Test
    public void testEqualityEvaluator() {
        try {
            HumanName name1 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.name{family=MCTEST}.0");
            HumanName name2 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.name{family=TESTERSON}.0");
            Assertions.assertNotNull(name1);
            Assertions.assertNotNull(name2);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate equality evaluator");
        }
    }

    @Test
    public void testNonEqualityEvaluator() {
        try {
            List<HumanName> name1 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.name{family!=MCTEST}");
            List<HumanName> name2 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.name{family!=TESTERSON}");
            Assertions.assertEquals(1, name1.size());
            Assertions.assertEquals(1, name2.size());
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate non-equality evaluator");
        }
    }

    @Test
    public void testGreaterThanEvaluator() {
        try {
            List<Extension> dailyDoseOver1 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(dailyDose){value>1}");
            List<Extension> dailyDoseOver5 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(dailyDose){value>5}");
            Assertions.assertEquals(2, dailyDoseOver1.size());
            Assertions.assertEquals(1, dailyDoseOver5.size());
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate greater than evaluator");
        }
    }

    @Test
    public void testGreaterThanEqualsEvaluator() {
        try {
            List<Extension> dailyDoseOver5 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(dailyDose){value>=5}");
            List<Extension> dailyDoseOver10 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(dailyDose){value>=10}");
            Assertions.assertEquals(2, dailyDoseOver5.size());
            Assertions.assertEquals(1, dailyDoseOver10.size());
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate greater than or equals evaluator");
        }
    }

    @Test
    public void testLessThanEvaluator() {
        try {
            List<Extension> dailyDoseBelow10 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(dailyDose){value<10}");
            List<Extension> dailyDoseBelow5 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(dailyDose){value<5}");
            Assertions.assertEquals(1, dailyDoseBelow10.size());
            Assertions.assertEquals(0, dailyDoseBelow5.size());
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate less than evaluator");
        }
    }

    @Test
    public void testLessThanEqualsEvaluator() {
        try {
            List<Extension> dailyDoseBelow10 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(dailyDose){value<=10}");
            List<Extension> dailyDoseBelow5 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(dailyDose){value<=5}");
            Assertions.assertEquals(2, dailyDoseBelow10.size());
            Assertions.assertEquals(1, dailyDoseBelow5.size());
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate less than or equals evaluator");
        }
    }

    @Test
    public void testRegexEqualityEvaluator() {
        try {
            List<HumanName> name1 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.name{given%=TEST}");
            List<HumanName> name2 = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.name{given!%=TEST}");
            Assertions.assertEquals(2, name1.size());
            Assertions.assertEquals(0, name2.size());
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate regex equality evaluators");
        }
    }

    private Bundle buildBundle() {
        Bundle bundle = new Bundle();
        // ClaimResponse
        ClaimResponse claimResponse = new ClaimResponse();
        bundle.addEntry().setResource(claimResponse);
        claimResponse.setId("ClaimResponse");
        claimResponse.addExtension().setUrl("someDate").setValue(new DateType("2024-01-01"));
        // Organization
        Organization organization = new Organization();
        organization.setId("Test Organization");
        claimResponse.setInsurer((Reference) new Reference().setResource(organization));
        // Patient
        Patient patient = new Patient();
        patient.addExtension().setUrl("nickname").setValue(new StringType("Fake"));
        patient.addExtension().setUrl("nickname").setValue(new StringType("Fake2"));
        patient.addExtension().setUrl("dailyDose").setValue(new IntegerType(5));
        patient.addExtension().setUrl("dailyDose").setValue(new IntegerType(10));
        claimResponse.setPatient((Reference) new Reference().setResource(patient));
        Identifier patientId = patient.addIdentifier();
        patientId.setType(new CodeableConcept().addCoding(new Coding().setCode("ID"))).setValue("Test Patient");
        Identifier patientId2 = patient.addIdentifier();
        patientId2.setType(new CodeableConcept().addCoding(new Coding().setCode("ID2")))
                .setValue("Test Patient 2")
                .setSystem("TEST");
        patientId2.getType().addCoding().setCode("ID3");
        patient.addName().setFamily("TESTERSON").addGiven("TEST");
        patient.addName().setFamily("MCTEST").addGiven("TEST");
        // Coverage
        Coverage coverage = new Coverage();
        coverage.setBeneficiary((Reference) new Reference().setResource(patient));
        coverage.setSubscriberId("Subscriber ID");
        CodeableConcept coverageType = new CodeableConcept();
        coverageType.addCoding().setCode("Test Type");
        coverage.addExtension().setUrl("type").setValue(coverageType);
        claimResponse.addContained(coverage);
        return bundle;
    }

}
