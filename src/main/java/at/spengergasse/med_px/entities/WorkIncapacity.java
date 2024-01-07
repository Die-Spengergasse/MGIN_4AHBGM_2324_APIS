package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkIncapacity extends Document{

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
