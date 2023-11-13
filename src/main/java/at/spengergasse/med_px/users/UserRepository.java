/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.users;

import at.spengergasse.med_px.entities.MedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for accessing table user in database
 */
@Repository
public interface UserRepository extends JpaRepository<MedUser, String> {
}
