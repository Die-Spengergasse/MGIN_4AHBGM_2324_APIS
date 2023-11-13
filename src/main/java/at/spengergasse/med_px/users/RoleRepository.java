/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.users;

import at.spengergasse.med_px.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for accessing table role in database
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
