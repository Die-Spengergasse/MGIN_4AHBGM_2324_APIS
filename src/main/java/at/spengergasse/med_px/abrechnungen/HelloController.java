package at.spengergasse.med_px.abrechnungen;

import at.spengergasse.med_px.entities.Abrechnung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abrechnungen/")
public class HelloController {
    @Autowired
    HelloRepository repository;

    @GetMapping("/all")
    public List<Abrechnung> allAbrechnungen() throws InterruptedException {

        // GET http://localhost:8080/api/abrechnungen/all

        Thread.sleep(1000);

        return List.of(
                new Abrechnung("Herr","Blazej Jaros","Kniescheibe","KFA","Keine"),
                new Abrechnung("Mr.","Riös ","Hirntumor","other","tot")
        );

    }


    @PostMapping("/")
    public Abrechnung abrechnung(@RequestBody Abrechnung a) {
        repository.save(a);
        return a;
    }

}
