package org.fhirpath.readers;

import org.fhirpath.readers.framework.FhirPathReader;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseFhirPathReaderTest {

    private final FhirPathReader fhirPathReader;
    private final Bundle bundle;

    public BaseFhirPathReaderTest() {
        this.fhirPathReader = new BaseFhirPathReader();
        this.bundle = this.buildBundle();
    }

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
    public void testConditionalExtensionAlias() {
        try {
            String nickname = this.fhirPathReader.read(this.bundle, "$ClaimResponse.patient.resource.extension(nickname){value=Fake2}.0.value");
            Assertions.assertEquals("Fake2", nickname);
        } catch (Exception e) {
            Assertions.fail("Failed to evaluate extension alias path");
        }
    }

    private Bundle buildBundle() {
        Bundle bundle = new Bundle();
        // ClaimResponse
        ClaimResponse claimResponse = new ClaimResponse();
        bundle.addEntry().setResource(claimResponse);
        claimResponse.addExtension().setUrl("someDate").setValue(new DateType("2024-01-01"));
        // Organization
        Organization organization = new Organization();
        organization.setId("Test Organization");
        claimResponse.setInsurer((Reference) new Reference().setResource(organization));
        // Patient
        Patient patient = new Patient();
        patient.addExtension().setUrl("nickname").setValue(new StringType("Fake"));
        patient.addExtension().setUrl("nickname").setValue(new StringType("Fake2"));
        claimResponse.setPatient((Reference) new Reference().setResource(patient));
        Identifier patientId = patient.addIdentifier();
        patientId.setType(new CodeableConcept().addCoding(new Coding().setCode("ID"))).setValue("Test Patient");
        Identifier patientId2 = patient.addIdentifier();
        patientId2.setType(new CodeableConcept().addCoding(new Coding().setCode("ID2")))
                .setValue("Test Patient 2")
                .setSystem("TEST");
        patientId2.getType().addCoding().setCode("ID3");
        return bundle;
    }

}
