package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a patient's contact (adress, phone, email, ...)
 * a patient may have more than one contact
 */
@Entity
@Table(name = "contact")
public class Contact extends Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vorname")
    private String vorname;

    @Column(name = "nachname")
    private String nachname;

    @ManyToOne
    @JoinColumn(name = "adresse")
    private City adresse;

    @Column(name = "email")
    private String email;

    @Column(name = "telefonnummer")
    private String telefonnummer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }


    public City getAdresse() {
        return adresse;
    }

    public void setAdresse(City adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }


    public Contact(Long id, String vorname, String nachname, City adresse, String email, String telefonnummer) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.email = email;
        this.telefonnummer = telefonnummer;
    }

    public Contact() {

    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", Adresse=" + adresse +
                ", email='" + email + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                '}';
    }
}
