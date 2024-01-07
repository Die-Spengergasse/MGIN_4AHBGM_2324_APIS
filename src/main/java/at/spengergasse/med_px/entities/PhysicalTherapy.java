package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class PhysicalTherapy extends Therapy{

    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private PhysioTherapist therapist;    // the therapist who performes the therapy

    @ManyToMany
    private List<Exercise> exercises;
}
