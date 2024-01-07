package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

@Entity
public class Referral {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;    // the medical case this referral belongs to

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;      // the specialist this referral is for
}
