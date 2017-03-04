package ui;

/**
 *
 * @author Acer
 */
public class EmptyFieldException extends RuntimeException {
    public EmptyFieldException() {
        this("Field is empty.");
    }
    
    public EmptyFieldException(String exception) {
        super(exception);
    }
}
