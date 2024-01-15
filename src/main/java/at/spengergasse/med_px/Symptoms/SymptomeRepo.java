package at.spengergasse.med_px.Symptoms;

import at.spengergasse.med_px.entities.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomeRepo extends JpaRepository<Symptom,String> {
}
