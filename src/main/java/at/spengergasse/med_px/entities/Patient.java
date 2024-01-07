package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "patient")
    private List<Contact> contacts;

    @OneToOne(mappedBy = "patient")
    private HealthRecord healthRecord;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;
}
