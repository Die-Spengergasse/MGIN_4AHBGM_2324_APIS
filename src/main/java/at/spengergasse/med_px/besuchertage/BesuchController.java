package at.spengergasse.med_px.besuchertage;

import at.spengergasse.med_px.entities.Patientenbesuch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BesuchController {
    @Autowired
    BesuchRepository repository;

    @GetMapping("besuch")
    public Collection<Patientenbesuch> patientenbesuches(){
        return repository.findAll();
    }

    @GetMapping("besuch/{id}")
    public Patientenbesuch patientenbesuch(@PathVariable int id){
        Optional<Patientenbesuch> item = repository.findById(id);
        if (item.isPresent()){
            return item.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "besucher existiert nicht");
    }

    @PostMapping("besuch")
    public Patientenbesuch patientenbesuch(@RequestBody Patientenbesuch b){
        repository.save(b);
        return b;
    }

    @DeleteMapping("besuch/{id}")
    public void delete(@PathVariable int id){
        repository.deleteById(id);
    }
}