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

}
