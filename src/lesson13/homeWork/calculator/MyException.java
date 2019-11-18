package lesson13.homeWork.calculator;

public abstract class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
