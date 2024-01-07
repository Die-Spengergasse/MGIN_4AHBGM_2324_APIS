package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SymptomCode {
    @Id
    private String code;
    private String description;
}
