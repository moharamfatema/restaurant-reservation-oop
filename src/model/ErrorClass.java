package model;

import View.AlertBox;

public class ErrorClass {
    private static String title = "ERROR";
    private static Errors errors;
    public static void loadError(){
        errors = Errors.LOAD;
        AlertBox.display(title,errors.getErrorMessage());
    }
    public static void saveError(){
        errors = Errors.SAVE;
        AlertBox.display(title,errors.getErrorMessage());
    }
    public static void accessError(){
        errors = Errors.ACCESS;
        AlertBox.display(title,errors.getErrorMessage());
    }
    public static void userInputError(){
        errors = Errors.USERINPUT;
        AlertBox.display(title,errors.getErrorMessage());
    }
}
