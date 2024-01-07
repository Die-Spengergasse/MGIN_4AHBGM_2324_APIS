package at.spengergasse.med_px.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ImageReport extends Report {
    @ManyToOne
    @JoinColumn(name = "imaging_type")
    private ImagingType type;
}
