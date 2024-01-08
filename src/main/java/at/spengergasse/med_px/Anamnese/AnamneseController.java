package at.spengergasse.med_px.Anamnese;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/anamnese")
public class AnamneseController {

    @Autowired
    private AnamneseRepository repository;
    ArrayList<Anamnese> anamnese = new ArrayList<>();

    @GetMapping("/all")
    public List<Anamnese> allAnamnese(){
        anamnese.add(new Anamnese(12345, "Susi", LocalDate.of(2005,2,3), "Mexalen", "keine", true));
        anamnese.add(new Anamnese(54321, "Friederika", LocalDate.of(2003,   2,1), "Parazitamol", "keine", false));
        anamnese.add(new Anamnese(13456, "Tom", LocalDate.of(2011,4,6), "Novalgin", "keine", true));
        anamnese.add(new Anamnese(54567, "Friedrich", LocalDate.of(2001,1,1), "Parazitamol", "keine", false));
        return anamnese;
    }

    @GetMapping("/{name}")
    public Anamnese getAnamneseByName(@PathVariable String name) {
        System.out.println(name);
        return new Anamnese(12345, "Susi", LocalDate.of(2005, 2, 3), "Mexalen", "keine", true);
    }


    @PostMapping("")
    public Anamnese addAnamnese(@RequestBody Anamnese anamnese) {
        repository.save(anamnese);
        return anamnese;

    }
    @PutMapping("/{svnr}")
    public Anamnese updateAnamnese(@PathVariable("svnr") int svnr, @RequestBody Anamnese updatedAnamnese){
        // 1. Wird in einen Stream umgewandelt und filtert die Liste der Anamnesen nach der Sozialversicherungsnummer (svnr)
        anamnese = (ArrayList<Anamnese>) anamnese.stream().filter(dokument -> dokument.getSvnr() == svnr).toList();
        // 2. Fügt die aktualisierte Anamnese an den Anfang der gefilterten Liste hinzu
        anamnese.add(0,updatedAnamnese);
        return updatedAnamnese;
    }
    @DeleteMapping("/{svnr}")
    public void deleteDokument(@PathVariable int svnr){
        anamnese.removeIf(dokument -> dokument.getSvnr() == svnr);
    }









}
