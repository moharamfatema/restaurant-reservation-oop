package model;

public enum Errors {
    SAVE("Couldn't save data"),
    LOAD("Couldn't load data"),
    USERINPUT("Invalid input"),
    ACCESS("Access denied");

    private final String errorMessage;

    Errors(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
