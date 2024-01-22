package at.spengergasse.med_px.document;

import at.spengergasse.med_px.entities.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    DocumentRepository repository;

    @GetMapping("dokumente")
    public Collection<Document> dokumente() {return repository.findAll();}

    @GetMapping("dokument/{id}")
    public Document dokument(@PathVariable long id){
        Optional<Document> item = repository.findById(id);
        if(item.isPresent()){
            return item.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dokument existiert nicht");
    }

    @PostMapping("dokument")
    public Document dokument(@RequestBody Document d){
        repository.save(d);
        return d;
    }

    @DeleteMapping("dokument/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }


}
