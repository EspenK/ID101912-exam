/**
 * Throw this exception when the municipality number is not in the specified range.
 *
 * This is a checked exception. It extends Exception.
 * The reason it should be a check exception is because it is expected to go wrong (if the user types in a incorrect number).
 * It is also possible to "recover from" as it does not break the program, it only needs the user to input the data again.
 */
public class MunicipalityNumberOutOfRangeException extends Exception {
    /**
     * Creates a MunicipalityNumberOutOfRangeException with a message that can be printed out for the user.
     * @param message The message to the user.
     */
    public MunicipalityNumberOutOfRangeException(String message) {
        super(message);
    }
}
