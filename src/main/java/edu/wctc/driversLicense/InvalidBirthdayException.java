package edu.wctc.driversLicense;

public class InvalidBirthdayException extends Exception{//subclass of Exception
    public InvalidBirthdayException(int year, int month, int day){
        //Constructor that calls the superclass constructor with a message
        //that the given year, month, and day are invalid.
        super("The Following Birthday is invalid: " + month + "-" + day + "-" + year);

    }
}
