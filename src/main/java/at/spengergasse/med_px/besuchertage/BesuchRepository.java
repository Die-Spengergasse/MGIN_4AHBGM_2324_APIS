package at.spengergasse.med_px.besuchertage;

import at.spengergasse.med_px.entities.Patientenbesuch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BesuchRepository extends JpaRepository<Patientenbesuch, Integer> {
}
