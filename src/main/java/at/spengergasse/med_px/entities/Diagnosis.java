package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a diagnosis usually refers a medical case and an ICD10 code
 */
@Entity
public class Diagnosis {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;        // the medical case the diagnosis refers to

    @ManyToOne
    @JoinColumn(name = "icd10_code")
    private Icd10 icd10;                    // the ICD10 code of the diagnosis
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;                  // the doctor who made the diagnosis
}
