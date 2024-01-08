package at.spengergasse.med_px.prescription;

import at.spengergasse.med_px.entities.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recipes")
public class PrescriptionControllers {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    private ArrayList<Prescription> prescription = new ArrayList<>();


    // GET http://localhost:8080/recipes/all
    @GetMapping("all")
    public Iterable<Prescription> getAllPrescription(){
        return prescriptionRepository.findAll();
    }

    // GET http://localhost:8080/recipes/{id}
    /*@GetMapping("/{id}")
    public Prescription getRecipeById(@PathVariable String id) {
        System.out.println(id);
        return id;
    }*/

    // GET http://localhost:8080/recipes?doctor=Dr. Saiti
    /*@GetMapping("/{doctor}")
    public Prescription getRecipeByName(@RequestParam String doctor) {
        System.out.println(doctor);
        return new Prescription
    }*/

    // POST http://localhost:8080/recipes/post
    /*@PostMapping("/post")
    public Prescription addRecipe(@RequestBody Prescription r) {
        prescriptionRepository.save(r);
        return r;
    }
*/
    //PUT http://localhost:8080/recipes/5
    /*@PutMapping("/{id}")
    public Prescription updateRecipe(@PathVariable int id, @RequestBody Prescription updatedRecipe) {
        prescription = (ArrayList<Prescription>) prescription.stream()
                .map(recipe1 -> (recipe1.getId() == id) ? updatedRecipe : recipe1)
                .collect(Collectors.toList());
        return updatedRecipe;
    }*/

    //DELETE http://localhost:8080/recipes/5
    /*@DeleteMapping("delete/{id}")
    public void deleteRecipe(@PathVariable int id) {prescriptionRepository.deleteById(id);
    }*/
}
