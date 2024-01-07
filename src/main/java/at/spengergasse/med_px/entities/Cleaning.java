package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * documentation of the cleaning of the rooms or devices
 */
@Entity
public class Cleaning {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;              // the room which was cleaned

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;      // the device which was cleaned

    @ManyToOne
    @JoinColumn(name = "personel_id")
    private CleaningPersonel personel;      // the personel who cleaned the room or device
}
