package ex1.exceptions;

public class DrinkNotFoundException extends ObjectNotFoundException {
    public DrinkNotFoundException(String message) {
        super(message);
    }
}
