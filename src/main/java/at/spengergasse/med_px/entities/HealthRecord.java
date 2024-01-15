package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * the basic health record of a patient
 */
@Entity
public class HealthRecord {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;        // the patient who owns the health record

    @ManyToMany
    private List<Allergy> allergies;    // the allergies of the patient








































































    private String bloodgroup;

    public String medication;

    public HealthRecord() {

    }

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

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public HealthRecord(Long id, Patient patient, List<Allergy> allergies, String bloodgroup, String medication){
        this.id = id;
        this.patient = patient;
        this.allergies = allergies;
        this.bloodgroup = bloodgroup;
        this.medication = medication;
    }

    @Override
    public String toString() {
        return "HealthRecord{" +
                "id=" + id +
                ", patient=" + patient +
                ", allergies=" + allergies +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", medication='" + medication + '\'' +
                '}';
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }
}
