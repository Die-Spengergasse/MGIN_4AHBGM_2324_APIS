package at.spengergasse.med_px.healthRecord;

import at.spengergasse.med_px.entities.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
}
