import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A class for testing the getAverageArea() method of the RealestateRegister class.
 */
public class RealestateRegisterTest {
    RealestateRegister realestateRegister;
    OwnerRegister owners;

    /**
     * Make the owner and real estate registers and fill them with test data.
     */
    @Before
    public void setUp() {
        realestateRegister = new RealestateRegister();
        owners = new OwnerRegister();

        owners.addOwner(new Individual("Per", "Plass1", "123455 54321"));
        owners.addOwner(new Individual("Ole", "En annen plass", "123456 54321"));
        owners.addOwner(new Company("Heftige investorer", "Bankveien 1", 987654321));
        owners.addOwner(new Company("Kjøper Alle Tomter .no", "Parkeringsplassen 2", 999999999));
        try {
            realestateRegister.addRealestate(new Realestate(
                    101,
                    "Halden",
                    1,
                    1,
                    "Brygga",
                    100,
                    owners.findOwnerByName("Heftige investorer")));
        } catch (MunicipalityNumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
        try {
            realestateRegister.addRealestate(new Realestate(
                    322,
                    "En plass",
                    332,
                    3,
                    "Plassen",
                    205.4,
                    owners.findOwnerByName("Ole")));
        } catch (MunicipalityNumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
        try {
            realestateRegister.addRealestate(new Realestate(
                    101,
                    "Halden",
                    138,
                    1,
                    "Den nye brygga",
                    300,
                    owners.findOwnerByName("Per")));
        } catch (MunicipalityNumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test if the getAverageAre() method calculates the average area correctly.
     */
    @Test
    public void getAverageArea() {
        double actual = (100 + 205.4 + 300) / 3;  // = 201.8
        double average = realestateRegister.getAverageArea();
        Assert.assertEquals(average, actual, 0.00);
    }
}