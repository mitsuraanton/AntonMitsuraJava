package lesson13.homeWork.calculator;

public class DividingByZeroOrNotIntValueException extends MyException {
    public DividingByZeroOrNotIntValueException(String message) {
        super(message);
    }

    public DividingByZeroOrNotIntValueException(String message, Throwable cause) {
        super(message, cause);
    }

}