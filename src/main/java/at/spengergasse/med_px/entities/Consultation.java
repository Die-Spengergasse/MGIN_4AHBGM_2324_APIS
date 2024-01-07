package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * this is when the patient actually meets the doctor for a consultation
 */
@Entity
public class Consultation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;    // the medical case the consultation refers to

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;              // the doctor who is consulted
}
