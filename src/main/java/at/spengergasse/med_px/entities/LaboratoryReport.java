package at.spengergasse.med_px.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

public class LaboratoryReport extends Report {

    @OneToMany
    @JoinColumn(name = "report_id")
    private List<MeasuredValue> values;   // the measured values of the report
}
