import java.util.HashMap;
import java.util.Iterator;

/**
 * A register to hold all owners.
 */
public class OwnerRegister {
    HashMap<String, Owner> owners;

    /**
     * Creates a owner register instance.
     */
    public OwnerRegister() {
        owners = new HashMap<>();
    }

    /**
     * Add a owner to the register.
     * @param owner The owner being added to the object.
     */
    public void addOwner(Owner owner) {
        owners.put(owner.getName(), owner);
    }

    /**
     * Returns a iterator with all the values from the register.
     *
     * @return a iterator with all the values from the register.
     */
    public Iterator<Owner> iterator() {
        return owners.values().iterator();
    }

    /**
     * Returns true if the register is empty.
     *
     * @return true if the register is empty.
     */
    public boolean isEmpty() {
        return owners.isEmpty();
    }

    /**
     * Returns the number of owners in the register.
     *
     * @return the number of owners in the register.
     */
    public int numberOfOwners() {
        return owners.size();
    }

    /**
     * Finds and returns a owner by name. If the owner is not found it will return null.
     * @param name The name of the owner we want to find.
     * @return the found owner or null if it was not found.
     */
    public Owner findOwnerByName(String name) {
        Owner foundOwner = null;
        if (owners.containsKey(name)) {
            foundOwner = owners.get(name);
        }
        return foundOwner;
    }
}
