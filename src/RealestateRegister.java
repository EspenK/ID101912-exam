import java.util.HashSet;
import java.util.Iterator;

/**
 * A real estate register holding information about real estates.
 */
public class RealestateRegister {
    HashSet<Realestate> realestateRegister;

    /**
     * Creates an instance of a real estate register.
     */
    public RealestateRegister() {
        realestateRegister = new HashSet<>();
    }

    /**
     * Add a real estate to the register.
     * @param realestate The real estate being added.
     */
    public void addRealestate(Realestate realestate) {
        realestateRegister.add(realestate);
    }

    /**
     * Returns true if the register is empty.
     *
     * @return true if the register is empty.
     */
    public boolean isEmpty() {
        return realestateRegister.isEmpty();
    }

    /**
     * Returns the number of real estates in the register.
     *
     * @return the number of real estates in the register.
     */
    public int numberOfRealestates() {
        return realestateRegister.size();
    }

    /**
     * Returns a iterator of the whole register.
     *
     * @return a iterator of the whole register.
     */
    public Iterator<Realestate> iterator() {
        return realestateRegister.iterator();
    }

    /**
     * Find a specific real estate and return it. All of the three parameters must match.
     *
     * @param municipalityNumber The municipality number of the wanted real estate.
     * @param lotNumber The lot number of the wanted real estate.
     * @param sectionNumber The section number of the wanted real estate.
     * @return Returns the found real estate, or null if it is not found.
     */
    public Realestate findRealestate(int municipalityNumber, int lotNumber, int sectionNumber) {
        Realestate foundRealestate = null;
        for (Realestate realestate : realestateRegister) {
            if ((realestate.getMunicipalityNumber() == municipalityNumber) &&
                    (realestate.getLotNumber() == lotNumber) &&
                    (realestate.getSectionNumber() == sectionNumber)) {
                foundRealestate = realestate;
            }
        }
        return foundRealestate;
    }

    /**
     * Returns the average area of all the real estates in the register.
     *
     * @return the average area of all the real estates in the register.
     */
    public double getAverageArea() {
        double totalArea = 0;
        for (Realestate realestate : realestateRegister) {
            totalArea += realestate.getArea();
        }
        double averageArea = totalArea / numberOfRealestates();
        return averageArea;
    }
}
