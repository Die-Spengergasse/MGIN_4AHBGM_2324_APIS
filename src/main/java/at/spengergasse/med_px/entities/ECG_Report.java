package at.spengergasse.med_px.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ECG_Report extends Report{
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;      // the device which was used to perform the ECG
}
