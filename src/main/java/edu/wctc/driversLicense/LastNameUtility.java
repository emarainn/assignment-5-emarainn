package edu.wctc.driversLicense;
import org.apache.commons.codec.language.Soundex;
public class LastNameUtility {
    private Soundex Soundex;

    public String encodeLastName (String lastName) throws MissingNameException{
        if(lastName.isEmpty()){
            //If the last name is blank, throws a MissingNameException.
            throw new MissingNameException("Last Name");
        }else {
            //Returns the encoding of the last name generated by the Soundex algorithm.
            return Soundex.encode(lastName);
        }
    }
}
