package at.spengergasse.med_px.laborbefund;

import at.spengergasse.med_px.entities.LaboratoryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborbefundRepository extends JpaRepository<LaboratoryReport, Integer> {
}
