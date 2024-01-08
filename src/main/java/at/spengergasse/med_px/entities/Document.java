package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a document belongs to a patient; there are different kinds of documents like reports, doctor's letter, ...
 * the original document / a printed version may be stored in some storage place
 */
@Entity
public class Document {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;            // the patient who owns the document

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;                // the storage place where the document is stored


    private String dokumentenname;

    private String dokumentenart;

    private String dokumentbeschreibung;

    public Document() {

    }

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

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getDokumentenname() {
        return dokumentenname;
    }

    public void setDokumentenname(String dokumentenname) {
        this.dokumentenname = dokumentenname;
    }

    public String getDokumentenart() {
        return dokumentenart;
    }

    public void setDokumentenart(String dokumentenart) {
        this.dokumentenart = dokumentenart;
    }

    public String getDokumentbeschreibung() {
        return dokumentbeschreibung;
    }

    public void setDokumentbeschreibung(String dokumentbeschreibung) {
        this.dokumentbeschreibung = dokumentbeschreibung;
    }

    public Document(Long id, Patient patient, Storage storage, String dokumentenname, String dokumentenart, String dokumentbeschreibung) {
        this.id = id;
        this.patient = patient;
        this.storage = storage;
        this.dokumentenname = dokumentenname;
        this.dokumentenart = dokumentenart;
        this.dokumentbeschreibung = dokumentbeschreibung;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", patient=" + patient +
                ", storage=" + storage +
                ", dokumentenname='" + dokumentenname + '\'' +
                ", dokumentenart='" + dokumentenart + '\'' +
                ", dokumentbeschreibung='" + dokumentbeschreibung + '\'' +
                '}';
    }
}
