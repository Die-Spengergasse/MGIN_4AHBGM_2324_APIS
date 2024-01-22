package at.spengergasse.med_px.Doctorsletter;

import at.spengergasse.med_px.entities.DoctorsLetter;
import at.spengergasse.med_px.Doctorsletter.DoctorsLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctorsLetters")
public class DoctorsLetterController {

    @Autowired
    private DoctorsLetterRepository doctorsLetterRepository;

    @GetMapping
    public ResponseEntity<?> getAllDoctorsLetters() {
        return ResponseEntity.ok(doctorsLetterRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorsLetter(@PathVariable Long id) {
        return doctorsLetterRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createDoctorsLetter(@RequestBody DoctorsLetter doctorsLetter) {
        return ResponseEntity.ok(doctorsLetterRepository.save(doctorsLetter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctorsLetter(@PathVariable Long id, @RequestBody DoctorsLetter updatedDoctorsLetter) {
        return doctorsLetterRepository.findById(id)
                .map(doctorsLetter -> {
                    doctorsLetter.setMedicalCase(updatedDoctorsLetter.getMedicalCase());
                    doctorsLetter.setDoctor(updatedDoctorsLetter.getDoctor());

                    return ResponseEntity.ok(doctorsLetterRepository.save(doctorsLetter));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctorsLetter(@PathVariable Long id) {
        return doctorsLetterRepository.findById(id)
                .map(doctorsLetter -> {
                    doctorsLetterRepository.delete(doctorsLetter);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
