package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a medical case, for example a patient consults the doctor because of stomach ache;
 * he may come several times for one case
 */

@Entity
public class MedicalCase {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;    // the patient who has the case
}
