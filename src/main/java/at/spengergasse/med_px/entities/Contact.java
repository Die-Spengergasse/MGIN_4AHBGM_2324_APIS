package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a patient's contact (adress, phone, email, ...)
 * a patient may have more than one contact
 */
@Entity
public class Contact {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;        // the patient who owns the contact

    @ManyToOne
    @JoinColumn(name = "city_zip")
    private City city;              // the city of the contact
}
