package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class MeasuredValue {
    @Id
    @GeneratedValue
    private Long id;
    private String name;     // name of the measured value
    private String unit;     // unit of the measured value
    private double value;    // value of the measured value

}
