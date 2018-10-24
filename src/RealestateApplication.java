
/**
 * A Realestate system. This interface defines the functionality required
 * from the real estate system. It is expected that a class implementing
 * this interface, implements all the methods defined in this interface.
 * 
 * <p>This interface and the class that implements it, is to be considered as
 * part of the <b>user interface</b>. Hence it is natural and accepted to have 
 * code that interacts with the user in the class implementing this interface.
 *
 * @author asty
 * @version 1.0
 */
public interface RealestateApplication
{

    /**
     * Initialize the application.
     * In this method is is common to create any business logic classes
     * to be used later in the applicaiton, like registers etc.
     */
    void init();
 
    /**
     * Register a new real estate to the register.
     */
    void doAddRealestatToRegister();

    /**
     * List all real estates in the register.
     */
    void doListAllRealestates();

    /**
     * Find a realestate in the register based on the municipality number,
     * lot number and section number.
     */
    void doFindRealestate();
    
    /**
     * Calculate the average area of all realestates int he register.
     */
    void doCalculateAverageRealestateArea();

}
