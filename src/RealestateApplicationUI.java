
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * the part of user interaction related to the menu, like displaying the menu,
 * and getting the choice from the user. When the user have selected which menu
 * item he/she would like to have executed, the execution is
 * <strong>delegated</strong> to the object of class
 * <code>RealestateApplication</code>.
 *
 * @author asty
 * @version 1.0
 */
class   RealestateApplicationUI
{
    private static final String VERSION = "v1.0";
    
    private RealestateApplication application = null;

    String[] menuItems =
    {
        "1. Add a Real estate to register",
        "2. List all real estates",
        "3. Search for a real estate",
        "4. Calculate average area of the real estates"
    };

    private final static int ADD_REALESTATE_TO_REGISTER = 1;
    private final static int LIST_ALL_REALESTATES = 2;
    private final static int FIND_REALESTATE = 3;
    private final static int CALCULATE_AVERAGE = 4;
    private final static int EXIT = 5;

    /**
     * Creates an instance of the RealestateApplicationUI User interface. An
     * instance of the RealestateApplication is created, and initialized.
     */
    public RealestateApplicationUI()
    {
        this.application = new RealestateApplicationImpl();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    void start()
    {
        this.application.init();

        boolean quit = false;

        while (!quit)
        {
            try
            {
                int menuSelection = this.showMenu();
                switch (menuSelection)
                {
                    case ADD_REALESTATE_TO_REGISTER:
                        this.application.doAddRealestatToRegister();
                        break;

                    case LIST_ALL_REALESTATES:
                        this.application.doListAllRealestates();
                        break;

                    case FIND_REALESTATE:
                        this.application.doFindRealestate();
                        break;

                    case CALCULATE_AVERAGE:
                        this.application.doCalculateAverageRealestateArea();
                        break;

                    case EXIT:
                        System.out.println("\nThank you for using Realestate Application " + VERSION + ". Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     * @throws InputMismatchException
     */
    private int showMenu() throws InputMismatchException
    {
        System.out.println("\n**** Real Estate Application " + VERSION + " ****\n");
        for (String menuItem : menuItems)
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");

        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

}
