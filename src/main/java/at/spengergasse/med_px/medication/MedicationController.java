package at.spengergasse.med_px.medication;

import at.spengergasse.med_px.entities.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medikation")
public class MedicationController {

    private ArrayList<Medication> medikations = new ArrayList<>();

    @GetMapping("/all")
    public List<Medication> allMedikations() {
        medikations.add(new Medication(1L,"Nurofen", "200mg", "Mittags", 13, "alles bestens"));
        medikations.add(new Medication(2L,"Parkemed", "250mg", "Abends", 13, "starke Kopfschmerzen"));
        return medikations;}

    @GetMapping("/{id}")
    public Medication getMedicationsById(@PathVariable int id) {
        return medikations.stream().filter(medikation -> medikation.getId() == id).findFirst().orElse(null);
    }

    @GetMapping
    public List<Medication> getMedikationsByName (@RequestParam String medikamentenname) {
        return medikations.stream()
                .filter(medikation -> medikation.getMedikamentenname().equals(medikamentenname)).collect(Collectors.toList());
    }

    @PostMapping
    public Medication addMedikations(@RequestBody Medication medikation) {
        medikations.add(medikation);
        return medikation;
    }

    @PutMapping("/{id}")
    public Medication updatePatient(@PathVariable int id, @RequestBody Medication updateMedikation) {
        medikations = (ArrayList<Medication>) medikations.stream()
                .map(medikation -> (medikation.getId() == id) ?updateMedikation : medikation)
                .collect(Collectors.toList());
        return updateMedikation;
    }

    @DeleteMapping("/{id}")
    public void deleteMedikation(@PathVariable int id) {
        medikations.removeIf(medikation -> medikation.getId() == id);
    }
}
