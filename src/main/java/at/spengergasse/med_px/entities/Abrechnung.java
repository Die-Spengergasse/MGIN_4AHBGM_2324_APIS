package at.spengergasse.med_px.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "a_abrechnungen")
public class Abrechnung {
    @Column(name = "a_titel")
    private String titel;
    @Id
    @Column(name = "a_name")
    private String name;
    @Column(name = "a_fall")
    private String fall;
    @Column(name = "a_svnr")
    private String svnr;
    @Column(name = "a_bemerkung")
    private String bemerkung;


    public Abrechnung(String titel, String name, String fall, String svnr, String bemerkung) {
        this.titel = titel;
        this.name = name;
        this.fall = fall;
        this.svnr = svnr;
        this.bemerkung = bemerkung;
    }

    public Abrechnung() {

    }

    public String getTitel() {
        return titel;
    }

    public String getName() {
        return name;
    }

    public String getFall() {
        return fall;
    }

    public String getSvnr() {
        return svnr;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFall(String fall) {
        this.fall = fall;
    }

    public void setSvnr(String svnr) {
        this.svnr = svnr;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    @Override
    public String toString() {
        return "Abrechnung{" +
                "titel='" + titel + '\'' +
                ", name='" + name + '\'' +
                ", fall='" + fall + '\'' +
                ", svnr='" + svnr + '\'' +
                ", bemerkung='" + bemerkung + '\'' +
                '}';
    }
}
