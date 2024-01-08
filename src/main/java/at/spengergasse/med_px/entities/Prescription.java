package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "dosage")
    private String dosage;
}
