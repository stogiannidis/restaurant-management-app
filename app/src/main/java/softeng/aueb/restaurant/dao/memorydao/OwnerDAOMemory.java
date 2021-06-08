package softeng.aueb.restaurant.dao.memorydao;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.OwnerDAO;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Owner;

public class OwnerDAOMemory implements OwnerDAO {
    protected static ArrayList<Owner> owners = new ArrayList<>();
    /**
     * Saves the owner to memory
     *
     * @param owner the owner of the restaurant
     */
    @Override
    public void save(Owner owner) {
        owners.add(owner);
    }

    /**
     * Deletes the owner from memory
     *
     * @param owner the owner of the restaurant
     */
    @Override
    public void delete(Owner owner) {
        owners.remove(owner);
    }

    /**
     * Finds the owner
     *
     * @param username Customer's username
     * @return the owner with that username or {@code null} if not found
     */
    @Override
    public Owner find(String username) {
        for (Owner owner: owners) {
            if(owner.getUsername().equals(username))
                return owner;
        }
        return null;
    }

    /**
     * @return All Owners
     */
    @Override
    public List<Owner> findAll() {
        return new ArrayList<>(owners);
    }

    @Override
    public boolean isEmailTaken(String email) {
        for (Owner owner: owners) {
            if(owner.getEmail().equals(email))
                return true;
        }
        return false;
    }

}
