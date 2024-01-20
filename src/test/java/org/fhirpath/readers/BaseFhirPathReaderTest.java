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
            Assertions.assertEquals("Test Patient", patientId);
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
        claimResponse.setPatient((Reference) new Reference().setResource(patient));
        Identifier patientId = patient.addIdentifier();
        patientId.setType(new CodeableConcept().addCoding(new Coding().setCode("ID"))).setValue("Test Patient");
        return bundle;
    }

}
