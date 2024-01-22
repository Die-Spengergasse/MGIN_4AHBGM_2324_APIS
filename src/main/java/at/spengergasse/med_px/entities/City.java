package at.spengergasse.med_px.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class City {
    @Id
    @Column(name = "plz")
    private int plz;

    @Column(name = "ort")
    private String ort;

    @Column(name = "strasse")
    private String strasse;

    // Konstruktor
    public City(int plz, String ort, String strasse) {
        this.plz = plz;
        this.ort = ort;
        this.strasse = strasse;
    }

    // Standardkonstruktor
    public City() {
    }

    // Getter und Setter für plz
    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    // Getter und Setter für ort
    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    // Getter und Setter für strasse
    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    // toString-Methode für die Ausgabe
    @Override
    public String toString() {
        return "City{" +
                "plz=" + plz +
                ", ort='" + ort + '\'' +
                ", strasse='" + strasse + '\'' +
                '}';
    }
}
