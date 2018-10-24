/**
 * A subclass of Owner. This is for individuals (private persons).
 */
public class Individual extends Owner {
    private String socialSecurityNumber;

    /**
     * Creates a instance of a individual.
     *
     * @param name    The owners name.
     * @param address The owners address.
     * @param socialSecurityNumber The individuals social security number.
     */
    public Individual(String name, String address, String socialSecurityNumber) {
        super(name, address);
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Returns the individuals social security number.
     *
     * @return the individuals social security number.
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}
