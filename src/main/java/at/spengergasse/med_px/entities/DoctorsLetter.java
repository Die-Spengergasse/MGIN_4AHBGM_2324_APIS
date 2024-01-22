package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * the doctor's letter is usually issued upon completion of a case
 */
@Entity
public class DoctorsLetter extends Document{

    @ManyToOne
    @JoinColumn(name = "case_id")
    private MedicalCase medicalCase;        // the medical case the letter refers to

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;              // the doctor who wrote the letter

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }

    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public DoctorsLetter(MedicalCase medicalCase, Doctor doctor) {
        this.medicalCase = medicalCase;
        this.doctor = doctor;
    }
}
