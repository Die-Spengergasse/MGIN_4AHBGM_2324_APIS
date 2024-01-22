package at.spengergasse.med_px.medication;

import at.spengergasse.med_px.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
