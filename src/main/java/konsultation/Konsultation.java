package konsultation;

import java.time.LocalDate;


public class Konsultation {

    private String name;
    private LocalDate date;
    private String symptoms;
    private String diagnosis;
    private String prescription;
    private int absencedates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public int getAbsencedates() {
        return absencedates;
    }

    public void setAbsencedates(int absencedates) {
        this.absencedates = absencedates;
    }

    public Konsultation(String name, LocalDate date, String symptoms, String diagnosis, String prescription, int absencedates) {
        this.name = name;
        this.date = date;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.absencedates = absencedates;
    }

    public Konsultation() {
    }
}
