package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Operation extends Therapy{
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;  // the doctor who performs the operation

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;  // the room where the operation takes place
}
