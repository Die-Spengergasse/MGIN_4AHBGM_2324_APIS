package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * the basic health record of a patient
 */
@Entity
public class HealthRecord {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;        // the patient who owns the health record
    @ManyToMany
    private List<Allergy> allergies;    // the allergies of the patient
}
