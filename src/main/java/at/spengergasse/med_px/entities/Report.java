package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a report is usually issued referring a medical case
 * there must be a doctor responsible for the report
 */
@Entity
public class Report {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
