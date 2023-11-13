package at.spengergasse.med_px.users;

import at.spengergasse.med_px.entities.MedUser;
import at.spengergasse.med_px.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * UserDetailsService based on UserRepository (accessing users table in database)
 * The UserDetailsService provides information about users
 */

/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    /**
     * provide user information for the user identified by the given user name
     * @param username user name of the requested user
     * @return user details of the requested user
     * @throws UsernameNotFoundException in case the user does not exist in the database
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    // https://stackoverflow.com/questions/10740021/transactionalpropagation-propagation-required
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MedUser> optional = repository.findById(username);
        if (optional.isEmpty()) throw new UsernameNotFoundException("no such user");
        MedUser medUser = optional.get();
        return User.withUsername(username)
            .password(medUser.getPassword())
            .roles(medUser.getRoles().stream().map(Role::getName).toArray(String[]::new))
            .build();
    }
}
