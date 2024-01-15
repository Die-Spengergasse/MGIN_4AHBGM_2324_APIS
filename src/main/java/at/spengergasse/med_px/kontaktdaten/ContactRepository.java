package at.spengergasse.med_px.kontaktdaten;

import at.spengergasse.med_px.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
