package edu.wctc.driversLicense;

import java.time.LocalDate;

public class MonthDayGenderUtility {

    private	final int MOD_MALE = 0;
    private	final int MOD_FEMALE = 500;
    private	final char CODE_MALE = 'M';
    private	final char CODE_FEMALE = 'F';

    public int encodeMonthDayGender(int year, int month, int day, char genderCode) throws UnknownGenderCodeException, InvalidBirthdayException{

        //Birthday Try Catch
        try {
            //creating a local date for birthday
            LocalDate birthday = LocalDate.of(year, month, day);
        }catch (Exception e){
            //If the year, month, and day of birth do not constitute a valid date
            throw new InvalidBirthdayException(year, month, day);
        }

        int monthDayGender = 0;
        //GenderCode Try Catch
        if(genderCode == 'M'){ //'' for char not ""
            //Returns (month - 1) * 40 + day + genderModConstant.
            monthDayGender = (month - 1) * 40 + day + MOD_MALE;
        }else if(genderCode == 'F'){
            monthDayGender = (month - 1) * 40 + day + MOD_FEMALE;
        }else {
            //If the gender code does not match one of the constants
            throw new UnknownGenderCodeException(genderCode);
        }

        return monthDayGender;


    }
}
