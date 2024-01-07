package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * used for maintaining a table of ICD10 codes in database
 */
@Entity
public class Icd10 {
    @Id
    private String code;        // the ICD10 code
    private String description; // the description of the ICD10 code
}
