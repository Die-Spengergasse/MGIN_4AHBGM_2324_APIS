package at.spengergasse.med_px.Symptoms;

import at.spengergasse.med_px.entities.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/symptoms")
public class SymptomsController {


    @Autowired
    private SymptomeRepo symptomeRepo;

    List<Symptom> symptomeList = new ArrayList<>();

    @PostMapping("/add")
    Symptom addSymptome(@RequestBody Symptom s) {

        symptomeList.add(s);

        System.out.println(s);
        return s;
    }

    @PutMapping("/put/{id}")
    public Symptom putSymptome(@PathVariable("id") int id, @RequestBody Symptom symptome) {
        Symptom s = symptomeList.stream().filter(sym -> sym.getId() == id).toList().get(0);
        s.setId(symptome.getId());
        s.setMedicalCase(symptome.getMedicalCase());
        return s;
    }

    @GetMapping("/all")
    public List<Symptom> symptome() {
        return symptomeRepo.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Symptom> getID(@PathVariable Integer id) {
        return symptomeRepo
                .findById(String.valueOf(id))
                .map(symptome -> ResponseEntity.ok().body(symptome))
                .orElse(ResponseEntity.notFound().build());

    }
}
