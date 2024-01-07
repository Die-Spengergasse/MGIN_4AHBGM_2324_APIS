package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a patient intends to meet a doctor, the appointment may refer a medical case
 * an appointment may be cancelled
 */
@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;        // the patient who intends to meet the doctor

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;      // the doctor who is intended to meet the patient

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;   // the medical case the appointment refers to
}
