package at.spengergasse.med_px.Medication;

import at.spengergasse.med_px.entities.Medication;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface MedicationRepository extends CrudRepository<Medication, Long> {

}
