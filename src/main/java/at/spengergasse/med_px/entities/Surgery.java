package at.spengergasse.med_px.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "ss_surgery")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "s_drname")
    private String drname;
    @Column(name = "s_paname")
    private String paname;
    @Column(name = "s_date")
    private LocalDate date;
    @Column(name = "s_surcase")
    private String surcase;
    @Column(name = "s_surintervention")
    private String surintervention;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrname() {
        return drname;
    }

    public void setDrname(String drname) {
        this.drname = drname;
    }

    public String getPaname() {
        return paname;
    }

    public void setPaname(String paname) {
        this.paname = paname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSurcase() {
        return surcase;
    }

    public void setSurcase(String surcase) {
        this.surcase = surcase;
    }

    public String getSurintervention() {
        return surintervention;
    }

    public void setSurintervention(String surintervention) {
        this.surintervention = surintervention;
    }

    public Surgery() {
        this.id = id;
        this.drname = drname;
        this.paname = paname;
        this.date = date;
        this.surcase = surcase;
        this.surintervention = surintervention;
    }
}