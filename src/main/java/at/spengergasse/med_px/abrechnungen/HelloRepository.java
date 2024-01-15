package at.spengergasse.med_px.abrechnungen;

import at.spengergasse.med_px.entities.Abrechnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<Abrechnung, Integer> {

}