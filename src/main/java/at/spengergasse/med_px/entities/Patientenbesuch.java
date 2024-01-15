package at.spengergasse.med_px.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "b_besuch")
public class Patientenbesuch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "b_name")
    private String besuchername;

    @Column (name = "b_besuchszeit")
    private LocalDateTime besuchszeit;

    @Column(name = "b_patientname")
    private String patientname ;

    @Override
    public String toString() {
        return "b_besuch{" +
                "id=" + id +
                ", b_name='" + besuchername + '\'' +
                ", b_besuchszeit='" + besuchszeit + '\'' +
                ", b_patientname=" + patientname +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBesuchername() {
        return besuchername;
    }

    public void setBesuchername(String besuchername) {
        this.besuchername = besuchername;
    }

    public LocalDateTime getBesuchszeit() {
        return besuchszeit;
    }

    public void setBesuchszeit(LocalDateTime besuchszeit) {
        this.besuchszeit = besuchszeit;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }
}
