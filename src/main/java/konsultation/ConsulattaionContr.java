package konsultation;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/konsultation")
public class ConsulattaionContr {
    private ArrayList<Konsultation> konsultationList = new ArrayList<>();


    public ConsulattaionContr() {
        konsultationList.add(new Konsultation("Jannat", LocalDate.of(2023, 01, 26), "Fieber", "Erkaeltung", "Vitamine", 3));
        konsultationList.add(new Konsultation("Labi", LocalDate.of(2023, 10, 06), "Husten", "Erkaeltung", "Antibiotika", 2));
        konsultationList.add(new Konsultation("Riham", LocalDate.of(2023, 07, 14), "Kopfweh", "Krank", "Paracetamol", 1));
        konsultationList.add(new Konsultation("Aleksandra", LocalDate.of(2023, 04, 11), "Schnupfen", "Krank", "Vitamine", 4));
    }

    @GetMapping("/all")
    public ArrayList<Konsultation> getAllKonsultationen() {
        return konsultationList;
    }

    @GetMapping("/{name}")
    public Konsultation getKonsultationByName(@PathVariable String name) {
        return konsultationList.stream()
                .filter(konsultation -> konsultation.getName() == name)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/patients")
    public List<Konsultation> getKonsultationByPatientName(@RequestParam("name") String name) {
        return konsultationList.stream()
                .filter(konsultation -> konsultation.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public void addKonsultation(@RequestBody Konsultation newKonsultation) {
        konsultationList.add(newKonsultation);
    }

    @PutMapping("/patients/{name}")
    public Konsultation updateKonsultationByName(@PathVariable String name, @RequestBody Konsultation updatedKonsultation) {
        for (Konsultation konsultation : konsultationList) {
            if (konsultation.getName() == name) {
                konsultation.setAbsencedates(updatedKonsultation.getAbsencedates());
                konsultation.setDate(updatedKonsultation.getDate());
                konsultation.setSymptoms(updatedKonsultation.getSymptoms());
                konsultation.setDiagnosis(updatedKonsultation.getDiagnosis());
                konsultation.setPrescription(updatedKonsultation.getPrescription());
                return konsultation;
            }
        }
        return null;
    }
    @DeleteMapping("/{name}")
    public void deleteKonsultationByName(@PathVariable String name) {
        Iterator<Konsultation> iterator = konsultationList.iterator();
        while (iterator.hasNext()) {
            Konsultation konsultation = iterator.next();
            if (konsultation.getName() == name) {
                iterator.remove();
                break;
            }
        }
    }
}
