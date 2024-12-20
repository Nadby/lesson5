package ex1.exceptions;

public class MilkRunOutException extends RuntimeException {
    public MilkRunOutException(String message) {
        super(message);
    }
}
