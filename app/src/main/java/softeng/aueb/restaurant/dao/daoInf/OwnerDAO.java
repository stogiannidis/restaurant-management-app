package softeng.aueb.restaurant.dao.daoInf;
import java.util.List;

import softeng.aueb.restaurant.domain.Owner;

/**
 * @author team23
 */

public interface OwnerDAO {
    /**
     * Saves the owner to memory
     * @param owner the owner of the restaurant
     */
    void save(Owner owner);

    /**
     * Deletes the owner from memory
     * @param owner the owner of the restaurant
     */
    void delete (Owner owner);

    /**
     *  Finds the owner
     * @param username Customer's username
     * @return the owner with that username or {@code null} if not found
     */
    Owner find (String username);

    /**
     *
     * @return All Owners
     */
    List<Owner> findAll();

    boolean isEmailTaken(String email);

}
