package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class ImagingType {
    @Id
    @GeneratedValue
    private Long id;
    private String description;     // description of the imaging type

    private String name;
    private LocalDate birth;
    private char gender;
    private String beschreibung;

    public ImagingType(Long id, String description, String name, LocalDate birth, char gender, String beschreibung) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.beschreibung = beschreibung;
    }

    public ImagingType() {

    }

    @Override
    public String toString() {
        return "ImagingType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", gender=" + gender +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
