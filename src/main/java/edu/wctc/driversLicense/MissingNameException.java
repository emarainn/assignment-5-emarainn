package edu.wctc.driversLicense;

public class MissingNameException extends Exception{//subclass of Exception
    public MissingNameException(String nameType){
        //Constructor that calls the superclass constructor with a message
        //that the name type (e.g. "first name") may not be blank.
        super(nameType + " - May not be blank");
    }

}
