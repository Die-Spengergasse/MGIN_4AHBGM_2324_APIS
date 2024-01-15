package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String krankenhaus;
    private int raumnummer;

    public Reservation(long id, String krankenhaus, int raumnummer) {
        this.id = id;
        this.krankenhaus = krankenhaus;
        this.raumnummer = raumnummer;
    }

    public Reservation() {

    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", krankenhaus='" + krankenhaus + '\'' +
                ", raumnummer=" + raumnummer +
                '}';
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKrankenhaus() {
        return krankenhaus;
    }

    public void setKrankenhaus(String Krankenhaus) {
        this.krankenhaus = krankenhaus;
    }
    public int getRaumnummer() {
        return raumnummer;
    }

    public void setRaumnummer(int raumnummer) {
        this.raumnummer = raumnummer;
    }
}
