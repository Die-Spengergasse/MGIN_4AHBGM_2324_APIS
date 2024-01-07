package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

@Entity
public class MedicationStock {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;  // the medication this stock belongs to

    private int stock;  // the amount of this medication in stock
}
