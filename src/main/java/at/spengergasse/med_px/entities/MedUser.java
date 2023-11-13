/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * entity class for user data
 * there is a N:M relationship with roles
 */
@Entity
@Table(name = "users")
public class MedUser {
    @Id
    private String name;
    private String password;
    @ManyToMany
    private List<Role> roles;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
