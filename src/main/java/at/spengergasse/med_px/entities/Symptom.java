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
    private SymptomCode code;        // the symptom code
}
