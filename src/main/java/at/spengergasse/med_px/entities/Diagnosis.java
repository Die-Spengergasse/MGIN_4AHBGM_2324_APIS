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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;        // the medical case the diagnosis refers to

    @ManyToOne
    @JoinColumn(name = "icd10_code")
    private Icd10 icd10;                    // the ICD10 code of the diagnosis
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;                  // the doctor who made the diagnosis

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }

    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }

    public Icd10 getIcd10() {
        return icd10;
    }

    public void setIcd10(Icd10 icd10) {
        this.icd10 = icd10;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
