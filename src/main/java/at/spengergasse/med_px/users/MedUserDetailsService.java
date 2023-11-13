/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * this class is actually not used
 * may be used to implement a simplified user authentication not based on database tables
 */
//@Service
public class MedUserDetailsService implements UserDetailsService {
    private final Map<String, String> users = new HashMap<>();

    @Autowired
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    public MedUserDetailsService(){
        users.put("admin", "admin");
        users.put("doctor", "doctor");
        users.put("user", "user");


    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        String pwd = users.get(username);
        if (pwd == null) throw new UsernameNotFoundException(username);
        UserDetails user;
        if (username.equals("admin")) {
        user = User.withUsername(username)
                    .password(encoder.encode(pwd))
                    .roles("ADMIN")
                    .build();

        } else if (username.equals("doctor")){
            user = User.withUsername(username)
                    .password(encoder.encode(pwd))
                    .roles("DOCTOR")
                    .build();
        } else {
            user = User.withUsername(username)
                    .password(encoder.encode(pwd))
                    .roles("USER")
                    .build();
        }

        return user;
    }


}