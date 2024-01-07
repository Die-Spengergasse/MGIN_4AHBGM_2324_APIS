package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

@Entity
public class Vaccination {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;
}
