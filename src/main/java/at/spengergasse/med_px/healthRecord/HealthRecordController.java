package at.spengergasse.med_px.healthRecord;

import at.spengergasse.med_px.entities.HealthRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/healthrecord")
public class HealthRecordController {

    @Autowired
    HealthRecordRepository repository;

    @GetMapping("grunddaten")
    public Collection<HealthRecord> grunddaten() {
        return repository.findAll();
    }

    @GetMapping("grunddaten/{id}")
    public HealthRecord grunddaten(@PathVariable long id) {
        Optional<HealthRecord> item = repository.findById(id);
        if (item.isPresent()) {
            return item.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grunddaten existieren nicht");
    }

    @PostMapping("grunddaten")
    public HealthRecord grunddaten(@RequestBody HealthRecord g) {
        repository.save(g);
        return g;
    }

    @DeleteMapping("grunddaten/{id}")
    public void delete(@PathVariable long id)
    {
        repository.deleteById(id);
    }
}
