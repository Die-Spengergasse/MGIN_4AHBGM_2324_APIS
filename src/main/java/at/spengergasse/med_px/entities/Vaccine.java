package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vaccine extends Medication{
    @Id
    @GeneratedValue
    private Long id;
}
