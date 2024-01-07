package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class MedicationTherapy extends Therapy{

    @OneToMany(mappedBy = "therapy")
    private List<Prescription> prescriptions;
}
