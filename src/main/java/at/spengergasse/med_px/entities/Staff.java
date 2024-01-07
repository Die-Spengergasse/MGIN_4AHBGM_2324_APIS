package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

@Entity
public class Staff {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;
}
