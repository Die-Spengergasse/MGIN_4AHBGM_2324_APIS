package at.spengergasse.med_px.lagerbestand;

import at.spengergasse.med_px.entities.Lagerbestand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;


//Rest: Web API, objektorientiert--> Objekte können eingefügt, gelöscht werden, arbeitet mit json
@RestController
@RequestMapping("/api/lagerbestand")     //dieser controller wird mit der url patients angesprochen http://localhost:8080/api/lagerbestand/all
public class LagerbestandController {

    @Autowired
    LagerbestandRepository repository;

    @GetMapping("lagerbestand/all")
    public Collection<Lagerbestand> books(){
        return repository.findAll();
    }

    @GetMapping("lagerbestand/{id}")
    public Lagerbestand book(@PathVariable int id){
        Optional<Lagerbestand> item = repository.findById(id);
        if (item.isPresent()){
            return item.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entry does not exist");
    }

    @PostMapping("lagerbestand")
    public Lagerbestand book(@RequestBody Lagerbestand l){
        repository.save(l);
        return l;
    }

    @DeleteMapping("lagerbestand/{id}")
    public void delete(@PathVariable int id){
        repository.deleteById(id);
    }

    /*@Autowired
    private LagerbestandRepository repository;

    ArrayList<Lagerbestand> list = new ArrayList<>();

    @GetMapping("/all")
    public List<Lagerbestand> allLagerbestand() throws InterruptedException {

        // GET http://localhost:8080/api/lagerbestand/all

        Thread.sleep(1000);

        return List.of(
                new Lagerbestand(1, "Spritze",25,05),
                new Lagerbestand(2, "Pflaster",500,03),
                new Lagerbestand(3, "Thermometer",40,05)
        );
    }


    //b) An endpoint for retrieving an entity with a specific id using a path variable (id)
    // http://localhost:8080/api/lagerbestand/id/1
   @GetMapping("/id/{id}")
    public Lagerbestand getLagerbestandById(@PathVariable ("id") int id){
        System.out.println(id);
       return new Lagerbestand(1, "Spritze",25,05);

    }

    //c) An endpoint for retrieving an entity using a search parameter (name)
    // http://localhost:8080/api/lagerbestand/name/Pflaster
   @GetMapping("/name/{name}")
    public List<Lagerbestand> getLagerbestandByName(@PathVariable ("name") String name){
        System.out.println(name);
        //return new Lagerbestand(2, "Pflaster", 500,03);
       return list.stream().filter(pflaster  -> pflaster.getName() == name).toList();

    }


    //d) An endpoint for storing a new entity using a request body
    //POST http://localhost:8080/api/lagerbestand/
    @PostMapping("/")
    public Lagerbestand addLagerbestand(@RequestBody Lagerbestand lagerbestand){
        System.out.println(lagerbestand);
        return lagerbestand;
    }

    //e) An endpoint for updating an entity using a request body and a path variable
    @PutMapping("put/{id}")
    public Lagerbestand update(@PathVariable("id") int id, @RequestBody Lagerbestand resource){
        List<Lagerbestand> templist = list.stream().filter(pflaster  -> pflaster.getId() == id).toList();
        templist.set(0, resource);
        return templist.get(0);
    }


    //f) An endpoint for deleting an entity using a path variable
    //DELETE http://localhost:8080/api/lagerbestand/delete/2
    @DeleteMapping("delete/{id}")
    public void deleteEntity(@PathVariable int id){
         {
            Lagerbestand l = list.stream().filter(pflaster  -> pflaster.getId() == id).toList().get(0);
            list.remove(l);
        }
    }*/
}
