package edu.wctc.driversLicense;

public class FloridaFormatter implements DriversLicenseFormatter{//subclass of DriversLicenseFormatter
    public String formatLicenseNumber (DriversLicense driversLicense){
        //Uses the getter methods of the driver's license object to retrieve the components
        //of the license number. Returns them in a String in the format of SSSS-FFF-YY-DDD-N

        return String.format(driversLicense.getSoundexCode() + "-"
                + driversLicense.getFirstNameMiddleInitial() + "-"
                + driversLicense.getBirthYear() + "-"
                + driversLicense.getBirthMonthDayGender() + "-"
                + driversLicense.getOverflow());
    }
}