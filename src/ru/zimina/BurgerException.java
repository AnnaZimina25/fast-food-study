package ru.zimina;

public class BurgerException extends Exception {
    private String message;

    public BurgerException (String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
