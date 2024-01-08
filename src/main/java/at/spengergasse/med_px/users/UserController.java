/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.users;

import at.spengergasse.med_px.entities.MedUser;
import at.spengergasse.med_px.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for a web service accessing users and roles
 */

@RestController
@RequestMapping("/api/admin/users")
public class UserController {

    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("all")
    public List<MedUser> allUsers(){
        return repository.findAll();
    }

    @GetMapping("roles")
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    @PostMapping("create")
    public MedUser create(@RequestBody MedUser u){
        u.setPassword(encoder.encode(u.getPassword()));
        return repository.save(u);
    }

    @PutMapping("update")
    public MedUser update(@RequestBody MedUser u){
        return repository.save(u);
    }

    @DeleteMapping("delete/{username}")
    public void delete(@PathVariable String username){
        repository.deleteById(username);
    }
}
