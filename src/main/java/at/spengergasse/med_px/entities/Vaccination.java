package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="va_vaccination")
public class Vaccination {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;


    private LocalDate dateOfVac;
    private int numOfVac;

    public Vaccination(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getDateOfVac() {
        return dateOfVac;
    }

    public void setDateOfVac(LocalDate dateOfVac) {
        this.dateOfVac = dateOfVac;
    }

    public int getNumOfVac() {
        return numOfVac;
    }

    public void setNumOfVac(int numOfVac) {
        this.numOfVac = numOfVac;
    }

    public Vaccination(Long id, Patient patient, Doctor doctor, Vaccine vaccine, LocalDate dateOfVac, int numOfVac) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.vaccine = vaccine;
        this.dateOfVac = dateOfVac;
        this.numOfVac = numOfVac;
    }
}
