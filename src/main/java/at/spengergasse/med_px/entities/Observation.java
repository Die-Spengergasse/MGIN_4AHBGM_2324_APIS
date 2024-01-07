package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Observation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;    // the medical case this observation belongs to

    @OneToMany
    @JoinColumn(name = "observation_id")
    private List<Symptom> symptoms;     // the symptoms associated with this observation
}
