package at.spengergasse.med_px.surgery;

import at.spengergasse.med_px.entities.Surgery;
import at.spengergasse.med_px.entities.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
