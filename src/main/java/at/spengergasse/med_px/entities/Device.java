package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * a medical device (like ECG, x-ray, autoclave, ...)
 */
@Entity
public class Device {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;          // the room where the device is located
}
