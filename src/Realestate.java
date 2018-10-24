/**
 * A class that holds information about a real estate.
 *
 * Only name, area and name of the owner are changeable. The other fields should not need to be changed.
 */
public class Realestate {
    private int municipalityNumber;
    private String municipalityName;
    private int lotNumber;
    private int sectionNumber;
    private String name;
    private double area;
    private Owner owner;

    /**
     * Creates an instance of a real estate.
     *
     * @param municipalityNumber The municipality number of the real estate.
     * @param municipalityName The name of the municipality of the real estate.
     * @param lotNumber The lot number.
     * @param sectionNumber The section number.
     * @param name The name of the real estate.
     * @param area The area of the real estate in square meters.
     * @param owner The owner of the real estate.
     * @throws MunicipalityNumberOutOfRangeException If the number is out of range the exception is thrown to let the user know it failed.
     */
    public Realestate(int municipalityNumber,
                      String municipalityName,
                      int lotNumber,
                      int sectionNumber,
                      String name,
                      double area,
                      Owner owner) throws MunicipalityNumberOutOfRangeException {
        if ((municipalityNumber >= 101) && (municipalityNumber <= 5054)) {
            this.municipalityNumber = municipalityNumber;
        } else {
            throw new MunicipalityNumberOutOfRangeException("Municipality number must be between 101 and 5054!");
        }

        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.owner = owner;
    }

    /**
     * Returns the municipality number of the real estate.
     *
     * @return the municipality number of the real estate.
     */
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    /**
     * Returns the municipality name of the real estate.
     * @return the municipality name of the real estate.
     */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * Returns the lot number of the real estate.
     *
     * @return the lot number of the real estate.
     */
    public int getLotNumber() {
        return lotNumber;
    }

    /**
     * Returns the section number of the real estate.
     *
     * @return the section number of the real estate.
     */
    public int getSectionNumber() {
        return sectionNumber;
    }

    /**
     * Returns the name of the real estate.
     *
     * @return the name of the real estate.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the area of the real estate in square meters.
     *
     * @return the are of the real estate in square meters.
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns the owner of the real estate.
     *
     * @return the owner of the real estate.
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Set the name of the real estate.
     *
     * @param name the new name of the real estate.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the area of the real estate in square meters.
     *
     * @param area the new area in square meters.
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Set the owner of the real estate.
     *
     * @param owner the new owner of the real estate.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
