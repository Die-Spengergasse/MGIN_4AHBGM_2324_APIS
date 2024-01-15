package at.spengergasse.med_px.surgery;

import at.spengergasse.med_px.entities.Surgery;
import at.spengergasse.med_px.entities.Surgery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/surgery")
public class SurgeryController {
    ArrayList<Surgery> list = new ArrayList<>();
    public SurgeryController(SurgeryRepository repository) {
        this.repository = repository;
    }
    SurgeryRepository repository;
    @GetMapping("/all")
    public List<Surgery> all(){
        Surgery s1 = new Surgery();
        s1.setId(1);
        s1.setDrname("Dr. Pasalic");
        s1.setPaname("Herr Jaros");
        s1.setDate(LocalDate.parse("2003-01-01"));
        s1.setSurcase("Blinddarmentzündung");
        s1.setSurintervention("Appendektomie");
        list.add(s1);
        Surgery s2 = new Surgery();
        s2.setId(2);
        s2.setDrname("Dr. Sarmiento");
        s2.setPaname("Benjamin Pasalic");
        s2.setDate(LocalDate.parse("2023-01-01"));
        s2.setSurcase("Herzinfarkt");
        s2.setSurintervention("CABG");
        list.add(s2);

        return list;
    }
    @GetMapping("/id/{id}")
    public List<Surgery> id(@PathVariable("id") int id) {

        return list.stream().filter(surgery -> surgery.getId() == id).toList();
    }

}
