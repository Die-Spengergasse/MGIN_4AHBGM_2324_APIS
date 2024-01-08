package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a patient's contact (adress, phone, email, ...)
 * a patient may have more than one contact
 */
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;        // the patient who owns the contact

    @ManyToOne
    @JoinColumn(name = "city_zip")
    private City city;              // the city of the contact

    @ManyToOne
    @JoinColumn(name = "email")
    private Patient email;

    @ManyToOne
    @JoinColumn(name = "phone")
    private Patient phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Patient getEmail() {
        return email;
    }

    public void setEmail(Patient email) {
        this.email = email;
    }

    public Patient getPhone() {
        return phone;
    }

    public void setPhone(Patient phone) {
        this.phone = phone;
    }

    public Contact(Long id, Patient patient, City city, Patient email, Patient phone) {
        this.id = id;
        this.patient = patient;
        this.city = city;
        this.email = email;
        this.phone = phone;
    }

    public Contact(){

    };

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", patient=" + patient +
                ", city=" + city +
                ", email=" + email +
                ", phone=" + phone +
                '}';
    }
}
