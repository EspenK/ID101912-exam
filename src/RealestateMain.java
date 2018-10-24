

/**
 * The Main-class of the application. This class contains the
 * public static void main()-method that starts the entire application.
 * 
 * @author asty
 * @version 1.0
 */
public class RealestateMain
{
    /**
     * The starting point for the application. <code>main</code> creates an
     * object instance of the {@link RealestateApplicationUI} and calls the
     * <code>start</code> method of the class.
     *
     * @param args Command line arguments. This application takes non.
     */
    public static void main(String[] args)
    {
        RealestateApplicationUI realestateAppUI = new RealestateApplicationUI();
        realestateAppUI.start();
    }

    /**
     * Make the constructor private to avoid accidental creation of
     * an object instance of this class.
     */
    private RealestateMain()
    {
        // Left empty intentionally
    }
    
}
