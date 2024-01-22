package at.spengergasse.med_px.Doctorsletter;



import at.spengergasse.med_px.entities.DoctorsLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsLetterRepository extends JpaRepository<DoctorsLetter, Long> {

}
