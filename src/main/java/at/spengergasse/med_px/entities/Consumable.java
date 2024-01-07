package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

/**
 * consumables which are in stock in the medical practice
 */
@Entity
public class Consumable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ConsumableCategory category;    // the category of the consumable
}
