package lesson13.homeWork.calculator;

public class WrongOperatorException extends MyException {
    public WrongOperatorException(String message) {
        super(message);
    }

    public WrongOperatorException(String message, Throwable cause) {
        super(message, cause);
    }
}