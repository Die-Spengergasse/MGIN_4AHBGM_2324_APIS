package at.spengergasse.med_px.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "lagerbestand")
public class Lagerbestand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "l_id")
    private int id;
    @Column(name = "l_name")
    private String name;
    @Column(name = "l_quantity")
    private int quantity;
    @Column(name = "l_fachnr")
    private int fachnr;

    public Lagerbestand(int id, String name, int quantity, int fachnr) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.fachnr = fachnr;
    }

    @Override
    public String toString() {
        return "Lagerbestand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", fachnr=" + fachnr +
                '}';
    }


    public Lagerbestand() {

    }

    public int getFachnr() {
        return fachnr;
    }

    public void setFachnr(int fachnr) {
        this.fachnr = fachnr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}