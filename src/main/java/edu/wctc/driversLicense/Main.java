package edu.wctc.driversLicense;

import org.apache.commons.codec.language.Soundex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n-----------------------" +
                "\nJava Assignment 5" +
                "\nEma Nimphius" +
                "\n09/28/2023" +
                "\n-----------------------");
        Soundex sounex = new Soundex();
        Scanner sc = new Scanner(System.in);

        //First, Middle Initial, Last Name & Soundex Coder
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine().toUpperCase();
        System.out.print("Enter Middle Initial: ");
        String middleInitial = sc.nextLine().toUpperCase();

        String lastName;
        String encoded;
        do {
            System.out.print("Enter Last Name: ");
            lastName = sc.nextLine();

            if(lastName.isEmpty()){
                System.out.println("**Must Enter Last Name**");
            }
            encoded = sounex.encode(lastName);
            //encode takes a string as an argument then turns it to soundex
            if (!encoded.isEmpty()){
                System.out.println(encoded);
                break;
            }
        }while (lastName != null);

        //YYYY, MM, DD, Gender(M/F)
        System.out.print("Year of birth(YYYY): ");
        int yyyy = sc.nextInt(); //nextInt because value type is an int
        System.out.print("Month of birth(MM): ");
        int mm = sc.nextInt();
        System.out.print("Year of birth(DD): ");
        int dd = sc.nextInt();

        System.out.print("Gender (M/F): ");
        char gender = sc.next().toUpperCase().charAt(0);

        //Try Catch
        try{
            //Creates a new DriversLicense object
            DriversLicense driversLicense = new DriversLicense();

            //Utility classes and the five setter methods to fill the object with data
            LastNameUtility lastNameUtility = new LastNameUtility();
            FirstNameUtility firstNameUtility = new FirstNameUtility();
            MonthDayGenderUtility monthDayGenderUtility = new MonthDayGenderUtility();

            //Setting the info
            //SoundexCoded
            driversLicense.setSoundexCode(encoded);
            //FirstNameMiddleInitial
            driversLicense.setFirstNameMiddleInitial(firstNameUtility.encodeFirstName(firstName, middleInitial));
            //Birth Year
            driversLicense.setBirthYear(yyyy);
            //Month Day Gender
            driversLicense.setBirthMonthDayGender(monthDayGenderUtility.encodeMonthDayGender(yyyy, mm, dd, gender));

            //Two formatter objects to print the driver's license numbers for Florida and Wisconsin
            WisconsinFormatter wisconsinFormatter = new WisconsinFormatter();
            FloridaFormatter floridaFormatter = new FloridaFormatter();
            System.out.println("\n--------------------------------" +
                    "\nLicense Number WI and FL:"
                    + "\nWisconsin: " + wisconsinFormatter.formatLicenseNumber(driversLicense)
                    + "\nFlorida: " + floridaFormatter.formatLicenseNumber(driversLicense));

        }catch (InvalidBirthdayException | MissingNameException | UnknownGenderCodeException e){
            //Prints Message
            System.out.println("The Following Error Has Occurred: " +
                    "\n\t" + e.getMessage()
                    + "\nExiting Program...");
            //Exits Program
            System.exit(1);
        }
    }

    public static void Notes() {
        //DOCUMENTATION
        //Multiple items in Try Catch Thing
        //https://www.programiz.com/java-programming/multiple-exceptions

        //CREATING YOUR NEW PROJECT:
        //--------------------------
        //pgerber1@wctc.edu
        //This started around 1:40
        //Build system was maven instead of Intellij
        //changed the groupId to edu.wctc.driversLicense
        //In the Java folder you created a new package with the name: edu.wctc.driversLicense
        //Created a new class called: Main
        //1:46 time stamp of loading Maven
        //Maven manages the external libraries
        //go into pom.xml, right click, generate, add dependency ("commons-codec 1.11")
        //Updated the version from 1.11 to: <version>1.16.0</version>
        //After doing everything above you now are done working with Maven for the assignment
        //***** only need one local date object, you will catch invalid dates ******
        //if you try to make a local date that doesnt exist you need to check for the runtime error
        //
    }
}
