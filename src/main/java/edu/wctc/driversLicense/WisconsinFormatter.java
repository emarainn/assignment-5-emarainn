package edu.wctc.driversLicense;

public class WisconsinFormatter implements DriversLicenseFormatter{
    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {
        //Uses the getter methods of the driver's license object to retrieve the components of the
        //license number. Returns them in a String in the format of SSSS-FFFY-YDDD-NN

        //I'M NOT SURE IF THE NUMBERS ARE RIGHT...
        String y = String.valueOf(driversLicense.getBirthYear()); //the whole year and converting to string
        String y1 = y.substring(2,3); //splitting it into parts
        String y2 = y.substring(3);

        return String.format(driversLicense.getSoundexCode() + "-"
                + driversLicense.getFirstNameMiddleInitial() + y1 + "-"
                + y2 + driversLicense.getBirthMonthDayGender() + "-"
                + driversLicense.getOverflow()+ driversLicense.getOverflow());

    }
}
