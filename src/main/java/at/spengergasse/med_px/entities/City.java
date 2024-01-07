package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class City {
    @Id
    private int zip;
    private String name;

}
