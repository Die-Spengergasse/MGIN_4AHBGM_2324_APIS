package at.spengergasse.med_px.mitarbeiter;

import at.spengergasse.med_px.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository <Staff, String>{
}
