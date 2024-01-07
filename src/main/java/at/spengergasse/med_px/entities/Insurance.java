package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Insurance {
    @Id
    @GeneratedValue
    private Long id;
    private String name;            // name of the insurance
}
