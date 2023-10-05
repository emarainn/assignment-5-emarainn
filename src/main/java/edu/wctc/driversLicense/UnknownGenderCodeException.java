package edu.wctc.driversLicense;

public class UnknownGenderCodeException extends Exception{
    public UnknownGenderCodeException(char genderCode){
        //Constructor that calls the superclass constructor with a message
        //that the given gender code is not known.
        System.out.println(genderCode + " - Is Unknown");

    }
}
