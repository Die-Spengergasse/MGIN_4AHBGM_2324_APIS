package at.spengergasse.med_px.vaccination;

import at.spengergasse.med_px.entities.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    VaccinationRepository repository;

    @GetMapping("/all")
   // GET http://localhost:8080/api/vaccination/all
    public List<Vaccination> allVaccination() {
    ArrayList<Vaccination> list = new ArrayList<>();
    list.add(new Vaccination());
    list.add(new Vaccination());
    list.add(new Vaccination());
    return list;
}
    //Unten "abgebildet" ist das gleiche wie oben
    //und macht auch das gleiche wie oben "abgebildet" nur ist das obere hardcoded
    //return List.of(
            //new Vaccination("Masern",LocalDate.of(2023,11,23),2),
            //new Vaccination("Hepatitis A",LocalDate.of(2023,12,25),1),
            //new Vaccination("Rubella",LocalDate.of(2024,1,16),1)

    //);

    @GetMapping("/id")
    // GET http://localhost:8080/api/vaccination/id
    public Vaccination getVaccinationById(@PathVariable long id){
        System.out.println(id);
        return new Vaccination();

    }

    @GetMapping("/find")
    // GET http://localhost:8080/api/vaccination/find/?typeOfVac={typeOfVac}
    public Vaccination getVaccinationByTypeOfVac(@RequestParam String typeOfVac){
        System.out.println(typeOfVac);
        return new Vaccination();
    }

    @PostMapping("/post")
    // POST http://localhost:8080/api/vaccination/
    public Vaccination addVaccination(@RequestBody Vaccination vaccination){
        repository.save(vaccination);
        return vaccination;
    }

    @DeleteMapping("vaccination/{id}")
    // DELETE http://localhost:8080/api/vaccination/5
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }

    @PutMapping("/api/vaccination/{id}")
    // PUT http://localhost:8080/api/vaccination/5
    public String updateVaccination(@PathVariable long id, @RequestBody Vaccination updatedVaccination){
        return "Vaccination with ID " + id + " has been updated!";
    }



}


