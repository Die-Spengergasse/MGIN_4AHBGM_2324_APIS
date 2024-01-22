package at.spengergasse.med_px.document;

import at.spengergasse.med_px.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
