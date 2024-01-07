package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoice extends Document{
    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;    // the case to which the invoice belongs

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;    // the insurance which is billed

}
