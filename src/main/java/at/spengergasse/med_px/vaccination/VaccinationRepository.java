package at.spengergasse.med_px.vaccination;

import at.spengergasse.med_px.entities.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
}
