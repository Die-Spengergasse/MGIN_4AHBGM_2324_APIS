package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Medication {
    @Id
    @GeneratedValue
    private Long id;

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", medikamentenname='" + medikamentenname + '\'' +
                ", dosis='" + dosis + '\'' +
                ", zeitdereinnahme='" + zeitdereinnahme + '\'' +
                ", altersgruppe=" + altersgruppe +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }

    public Medication(Long id, String medikamentenname, String dosis, String zeitdereinnahme, int altersgruppe, String beschreibung) {
        this.id = id;
        this.medikamentenname = medikamentenname;
        this.dosis = dosis;
        this.zeitdereinnahme = zeitdereinnahme;
        this.altersgruppe = altersgruppe;
        this.beschreibung = beschreibung;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedikamentenname() {
        return medikamentenname;
    }

    public void setMedikamentenname(String medikamentenname) {
        this.medikamentenname = medikamentenname;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getZeitdereinnahme() {
        return zeitdereinnahme;
    }

    public void setZeitdereinnahme(String zeitdereinnahme) {
        this.zeitdereinnahme = zeitdereinnahme;
    }

    public int getAltersgruppe() {
        return altersgruppe;
    }

    public void setAltersgruppe(int altersgruppe) {
        this.altersgruppe = altersgruppe;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    private String medikamentenname;           // name of the medication

    private String dosis;

    private String zeitdereinnahme;

    private int altersgruppe;

    private String beschreibung;

    public Medication() {

    }
}
