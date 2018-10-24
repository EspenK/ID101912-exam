/**
 * This is a subclass of Owner. Used for companies.
 */
public class Company extends Owner {
    private int orgNumber;

    /**
     * Creates a instance of a company.
     *
     * @param name    The owners name.
     * @param address The owners address.
     * @param orgNumber The companies org number.
     */
    public Company(String name, String address, int orgNumber) {
        super(name, address);
        this.orgNumber = orgNumber;
    }

    /**
     * Returns the companies org number.
     *
     * @return the companies org number.
     */
    public int getOrgNumber() {
        return orgNumber;
    }
}
