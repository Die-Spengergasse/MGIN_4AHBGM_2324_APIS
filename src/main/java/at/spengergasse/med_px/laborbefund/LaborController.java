package at.spengergasse.med_px.laborbefund;

import at.spengergasse.med_px.entities.LaboratoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/laborbefund")
public class LaborController {


    @Autowired
    private LaborbefundRepository repository;

    private ArrayList<LaboratoryReport> laborbefund = new ArrayList<>();

    //An endpoint for retrieving all entities (GET /api/patients/all)
    @GetMapping("/all")
    public List<LaboratoryReport> allLaborbefund() {
        return laborbefund;
    }

    //An endpoint for retrieving an entity with a specific id using a path variable (GET/api/patients/5)
    @GetMapping("/{svnr}")
    public LaboratoryReport getLaborbefundBySvnr(@PathVariable long svnr) {
        return laborbefund.stream()
                .filter(laborbefund -> laborbefund.getSvnr() == svnr)
                .findFirst()
                .orElse(null);
    }

    //An endpoint for retrieving an entity using a search parameter (GET
    ///api/patients?name=Susi)
    @GetMapping
    public List<LaboratoryReport> getLaborbefundeByName(@RequestParam String vorname) {
        return laborbefund.stream()
                .filter(laborbefund -> laborbefund.getVorname().equals(vorname))
                .collect(Collectors.toList());
    }


    //An endpoint for storing a new entity using a request body (POST /api/patients
    @PostMapping
    public LaboratoryReport createLaborbefund(@RequestBody LaboratoryReport laborbefund1) {
        laborbefund.add(laborbefund1);
        return laborbefund1;
    }

    //An endpoint for updating an entity using a request body and a path variable (PUT
    ///api/patients/5)
    @PutMapping("/{svnr}")
    public LaboratoryReport updateLaborbefund(@PathVariable long svnr, @RequestBody LaboratoryReport updatedLaborbefund) {
        laborbefund = (ArrayList<LaboratoryReport>) laborbefund.stream()
                .map(laborbefund1 -> (laborbefund1.getSvnr() == svnr) ? updatedLaborbefund : laborbefund1)
                .collect(Collectors.toList());
        return updatedLaborbefund;
    }

    //An endpoint for deleting an entity using a path variable (DELETE /api/patients/5)
    @DeleteMapping("/{svnr}")
    public void deleteLaborbefund(@PathVariable long svnr) {
        laborbefund.removeIf(laborbefund1 -> laborbefund1.getSvnr() == svnr);
    }
}

