package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * category of consumables (like injection, gloves, ...)
 */
@Entity
public class ConsumableCategory {
    @Id
    @GeneratedValue
    private Long id;
}
