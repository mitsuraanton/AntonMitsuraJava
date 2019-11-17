package lesson13.homeWork.calculator;

public class MissingNOrMException extends MyException {
    public MissingNOrMException(String message) {
        super(message);
    }

    public MissingNOrMException(String message, Throwable cause) {
        super(message, cause);
    }
}