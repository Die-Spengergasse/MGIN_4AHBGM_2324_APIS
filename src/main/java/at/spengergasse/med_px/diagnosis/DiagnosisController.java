package at.spengergasse.med_px.diagnosis;

import at.spengergasse.med_px.entities.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnoses")
public class DiagnosisController {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @GetMapping
    public List<Diagnosis> getAllDiagnoses() {
        return (List<Diagnosis>) diagnosisRepository.findAll();
    }

    @GetMapping("/{id}")
    public Diagnosis getDiagnosisById(@PathVariable Long id) {
        return diagnosisRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Diagnosis createDiagnosis(@RequestBody Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    @PutMapping("/{id}")
    public Diagnosis updateDiagnosis(@PathVariable Long id, @RequestBody Diagnosis updatedDiagnosis) {
        updatedDiagnosis.setId(id);
        return diagnosisRepository.save(updatedDiagnosis);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnosis(@PathVariable Long id) {
        diagnosisRepository.deleteById(id);
    }
}

