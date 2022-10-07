package exception;

public class OutOfStockExceptions extends RuntimeException{
    public OutOfStockExceptions(String message) {
        super(message);
    }
}
