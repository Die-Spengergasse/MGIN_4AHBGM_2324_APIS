package at.spengergasse.med_px.lagerbestand;

import at.spengergasse.med_px.entities.Lagerbestand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LagerbestandRepository extends JpaRepository<Lagerbestand, Integer> {
}
