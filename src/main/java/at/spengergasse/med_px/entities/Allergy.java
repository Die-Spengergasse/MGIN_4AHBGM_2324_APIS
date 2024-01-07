package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * provide a list of known allergies in the database
 */

@Entity
public class Allergy {
    @Id
    private String code;
    private String text;
}
