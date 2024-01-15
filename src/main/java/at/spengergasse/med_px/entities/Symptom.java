package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

@Entity
public class Symptom {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;    // the medical case this symptom belongs to

    @ManyToOne
    @JoinColumn(name = "symptom_code")
    private SymptomCode code;// the symptom code

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }

    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }

    public SymptomCode getCode() {
        return code;
    }

    public void setCode(SymptomCode code) {
        this.code = code;
    }
}
