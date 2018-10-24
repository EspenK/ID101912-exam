
import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents the RealestateApplication. The class is a delegate for the main
 * application and the menu-system. Any functions triggered by a menu selection
 * leads to a call to one of the methods in this class (via the
 * RealestateApplication interface).
 *
 * @author asty
 * @version 0.1
 */
public class RealestateApplicationImpl implements RealestateApplication
{
    private RealestateRegister realestateRegister;
    private OwnerRegister owners;

    @Override
    public void init()
    {
        realestateRegister = new RealestateRegister();
        owners = new OwnerRegister();

        this.fillRegistersWithDataForTesting();

    }

    /**
     * Takes user input and adds a real estate to the register.
     */
    @Override
    public void doAddRealestatToRegister() {
        System.out.println("To add a real estate to the register you need to provide some details.");
        System.out.println("Here are the owners you can choose from.");  // TODO: La brukeren opprette Owner.
        Iterator<Owner> it = owners.iterator();
        while (it.hasNext()) {
            Owner owner = it.next();
            System.out.println(owner.getName());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Municipality number (kommune nr): ");
        String municipalityNumberString = scanner.nextLine();
        int municipalityNumber = Integer.parseInt(municipalityNumberString);

        System.out.println("Municipality name: ");
        String municipalityName = scanner.nextLine();

        System.out.println("Lot number (gnr): ");
        String lotNumberString = scanner.nextLine();
        int lotNumber = Integer.parseInt(lotNumberString);

        System.out.println("Section number (bnr): ");
        String sectionNumberString = scanner.nextLine();
        int sectionNumber = Integer.parseInt(sectionNumberString);

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Area: ");
        String areaString = scanner.nextLine();
        double area = Double.parseDouble(areaString);

        boolean validOwner = false;
        Owner owner = null;
        while (!validOwner) {
            System.out.println("Name of the owner: ");
            String nameOfOwner = scanner.nextLine();
            if (owners.findOwnerByName(nameOfOwner) != null) {
                owner = owners.findOwnerByName(nameOfOwner);
                validOwner = true;
            } else {
                System.out.println("Invalid name of owner, please try again.");
            }
        }
        Realestate realestate = null;
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
            realestateRegister.addRealestate(realestate);
            System.out.println("Real estate added to the register.");
        } catch (MunicipalityNumberOutOfRangeException e) {
            System.out.println(e.getMessage());
            System.out.println("Real estate was not added to the register.");
        }
    }

    /**
     * List all the real estates in the register.
     */
    @Override
    public void doListAllRealestates() {
        if (!realestateRegister.isEmpty()) {
            System.out.println("Listing all real estates\n");
            String format = "%-20s %-20s %-12s %-20s %-20s %-8s %-20s";
            System.out.printf(format,
                    "Municipality number",
                    "Municipality name",
                    "Lot number",
                    "Section number",
                    "Name",
                    "Area m²",
                    "Owner");
            Iterator<Realestate> it = realestateRegister.iterator();
            while (it.hasNext()) {
                Realestate realestate = it.next();
                System.out.printf("\n" + format,
                        realestate.getMunicipalityNumber(),
                        realestate.getMunicipalityName(),
                        realestate.getLotNumber(),
                        realestate.getSectionNumber(),
                        realestate.getName(),
                        realestate.getArea(),
                        realestate.getOwner().getName());
            }
        } else {
            System.out.println("No real estates to display.");
        }

    }

    /**
     * Takes user input to find a real estate. Displays the real estate if found.
     */
    @Override
    public void doFindRealestate() {
        System.out.println("To find a real estate you need to fill in some details.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Municipality number (kommune nr): ");
        String municipalityNumberString = scanner.nextLine();
        int municipalityNumber = Integer.parseInt(municipalityNumberString);

        System.out.println("Lot number (gnr): ");
        String lotNumberString = scanner.nextLine();
        int lotNumber = Integer.parseInt(lotNumberString);

        System.out.println("Section number (bnr): ");
        String sectionNumberString = scanner.nextLine();
        int sectionNumber = Integer.parseInt(sectionNumberString);

        Realestate realestate = realestateRegister.findRealestate(municipalityNumber, lotNumber, sectionNumber);
        if (realestate != null) {
            System.out.println("The real estate was found: ");
            String format = "%-20s %-20s %-12s %-20s %-20s %-8s %-20s";
            System.out.printf(format,
                    "Municipality number",
                    "Municipality name",
                    "Lot number",
                    "Section number",
                    "Name",
                    "Area m²",
                    "Owner");
            System.out.printf("\n" + format,
                    realestate.getMunicipalityNumber(),
                    realestate.getMunicipalityName(),
                    realestate.getLotNumber(),
                    realestate.getSectionNumber(),
                    realestate.getName(),
                    realestate.getArea(),
                    realestate.getOwner().getName());
        } else {
            System.out.println("The real estate was not found.");
        }
    }

    /**
     * Displays the average area of all real estates in the register.
     */
    @Override
    public void doCalculateAverageRealestateArea() {
        if (!realestateRegister.isEmpty()) {
            double averageArea = realestateRegister.getAverageArea();
            System.out.println("\nThe average area of the real estates is " + averageArea + " m².");
        } else {
            System.out.println("No real estates to display.");
        }
    }
    
    /**
     * A helper method that fills the register(s) with some
     * data for testing purposes.
     */
    private void fillRegistersWithDataForTesting()
    {
        owners.addOwner(new Individual("Per", "Plass1", "123455 54321"));
        owners.addOwner(new Individual("Ole", "En annen plass", "123456 54321"));
        owners.addOwner(new Company("Heftige investorer", "Bankveien 1", 987654321));
        owners.addOwner(new Company("Kjøper Alle Tomter .no", "Parkeringsplassen 2", 123456789));
        try {
            realestateRegister.addRealestate(new Realestate(
                    101,
                    "Halden",
                    1,
                    1,
                    "Brygga",
                    140.3,
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
                    208.1,
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
                    402,
                    owners.findOwnerByName("Per")));
        } catch (MunicipalityNumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
