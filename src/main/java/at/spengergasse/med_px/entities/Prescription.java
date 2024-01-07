package at.spengergasse.med_px.entities;

import jakarta.persistence.*;


@Entity
public class Prescription {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "therapy_id")
    private MedicationTherapy therapy;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;
}
