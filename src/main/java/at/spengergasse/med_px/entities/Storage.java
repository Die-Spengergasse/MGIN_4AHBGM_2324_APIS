package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Storage {
    @Id
    @GeneratedValue
    private Long id;
}
