package at.spengergasse.med_px.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class CleaningPersonel extends Staff{
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "personel")
    private List<Cleaning> cleanings;       // the cleanings which were done by this personel
}
