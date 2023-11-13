/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.entities;


import jakarta.persistence.*;

/**
 * entity class for roles - there is a N:M relationship with users
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    private String name;
    private String description;
//    @ManyToMany
//    private List<MedUser> users;


    public String getName() {
        return name;
    }
}
