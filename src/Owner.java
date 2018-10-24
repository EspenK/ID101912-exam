/**
 * A super class for all owners.
 */
public class Owner {
    private String name;
    private String address;

    /**
     * Creates a instance of a owner.
     *
     * @param name The owners name.
     * @param address The owners address.
     */
    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Returns the owners name.
     *
     * @return the owners name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the owners address.
     *
     * @return the owners address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets a new address for the owner.
     *
     * @param address The owners new address.
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
