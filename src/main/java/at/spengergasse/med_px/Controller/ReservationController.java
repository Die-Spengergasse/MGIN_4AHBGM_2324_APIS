package at.spengergasse.med_px.Controller;

import at.spengergasse.med_px.entities.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api/behandlungsraumen")
public class ReservationController {

    private ArrayList<Reservation> behandlungsraumen = new ArrayList<>();

    @GetMapping("/all")
    public List<Reservation> allBehandlungsraumen() {
        return behandlungsraumen;
    }

    @GetMapping("/{id}")
    public Reservation getBehandlungsraumenById(@PathVariable long id) {
        return behandlungsraumen.stream()
                .filter(behandlungsraumen -> behandlungsraumen.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping
    public List<Reservation> getBehandlungsraumenByName(@RequestParam String krankenhaus) {
        return behandlungsraumen.stream()
                .filter(behandlungsraumen -> behandlungsraumen.getKrankenhaus().equals(krankenhaus))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public Reservation addBehandlungsraumen(@RequestBody Reservation raumnummer) {
        behandlungsraumen.add(raumnummer);
        return raumnummer;
    }

    @PutMapping("/{id}")
    public Reservation updatePatient(@PathVariable long id, @RequestBody Reservation updatedBehandlungsraum) {
        behandlungsraumen = (ArrayList<Reservation>) behandlungsraumen.stream()
                .map(behandlungsraum -> (behandlungsraum.getId() == id) ? updatedBehandlungsraum : behandlungsraum)
                .collect(Collectors.toList());
        return updatedBehandlungsraum;
    }

    @DeleteMapping("/{id}")
    public void deleteRaumnummer(@PathVariable long id) {
        behandlungsraumen.removeIf(raumnummer -> raumnummer.getId() == id);
    }
}
