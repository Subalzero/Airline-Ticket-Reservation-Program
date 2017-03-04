package ui;

/**
 *
 * @author Acer
 */
public class InvalidPasswordException extends RuntimeException {
    
    public InvalidPasswordException() {
        this("Invalid Password");
    }
    
    public InvalidPasswordException(String exception) {
        super(exception);
    }
}
