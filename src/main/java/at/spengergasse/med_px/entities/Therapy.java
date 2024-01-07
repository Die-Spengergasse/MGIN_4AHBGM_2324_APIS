package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

@Entity
public class Therapy {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;
}
