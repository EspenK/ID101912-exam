import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A class for testing the constructor and getters of the Realestate class.
 */
public class RealestateTest {
    private Realestate realestate;
    private int municipalityNumber = 101;
    private String municipalityName = "Halden";
    private int lotNumber = 43;
    private int sectionNumber = 12;
    private String name = "Kaia";
    private double area = 893.4;
    private Owner owner;

    /**
     * Make the owner and real estate object before running the test.
     */
    @Before
    public void setUp() {
        owner = new Company("Norge AS", "Kongehuset", 100000000);

        try {
            realestate = new Realestate(
                    municipalityNumber,
                    municipalityName,
                    lotNumber,
                    sectionNumber,
                    name,
                    area,
                    owner
            );
        } catch (MunicipalityNumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test that the municipality number we put in the constructor equals what we get out of the object.
     */
    @Test
    public void getMunicipalityNumber() {
        Assert.assertEquals(realestate.getMunicipalityNumber(), municipalityNumber);
    }

    /**
     * Test that the municipality name we put in the constructor equals what we get out of the object.
     */
    @Test
    public void getMunicipalityName() {
        Assert.assertEquals(realestate.getMunicipalityName(), municipalityName);
    }

    /**
     * Test that the lot number we put in the constructor equals what we get out of the object.
     */
    @Test
    public void getLotNumber() {
        Assert.assertEquals(realestate.getLotNumber(), lotNumber);
    }

    /**
     * Test that the section number we put in the constructor equals what we get out of the object.
     */
    @Test
    public void getSectionNumber() {
        Assert.assertEquals(realestate.getSectionNumber(), sectionNumber);
    }

    /**
     * Test that the name we put in the constructor equals what we get out of the object.
     */
    @Test
    public void getName() {
        Assert.assertEquals(realestate.getName(), name);
    }

    /**
     * Test that the area we put in the constructor equals what we get out of the object.
     */
    @Test
    public void getArea() {
        Assert.assertEquals(realestate.getArea(), area, 0.00);
    }

    /**
     * Test that the owner we put in the constructor equals what we get out of the object.
     */
    @Test
    public void getOwner() {
        Assert.assertEquals(realestate.getOwner(), owner);
    }
}