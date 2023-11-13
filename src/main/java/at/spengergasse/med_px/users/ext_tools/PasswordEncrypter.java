/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.users.ext_tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * class for encryption of password - can be used for manually inserting users
 */
public class PasswordEncrypter {
    public static void main(String[] args) {
        if (args.length == 1) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            System.out.println(encoder.encode(args[0]));
        }
        else {
            System.out.println("usage: java ext_tools.PasswordEncrypter <pwd>" );
        }
    }
}
