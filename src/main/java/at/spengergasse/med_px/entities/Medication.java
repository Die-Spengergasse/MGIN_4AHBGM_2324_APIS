package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Medication {
    @Id
    @GeneratedValue
    private Long id;

    private String name;            // name of the medication

    private int dose;
}
