package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.enums.*;

import java.util.*;

import static com.ironhack.utils.Checker.*;
import static com.ironhack.utils.Checker.checkCompName;

public class ScanInfo {
    private static Scanner scanner = new Scanner(System.in);

    public static String askName(){
        //Set a boolean to false to enter the loop
        Boolean validName=false;

        //Initialise name to be able to access it inside the loop and return it
        String name = "";

        while(!validName){
            System.out.println("Please, provide a name");
            try {
                name = scanner.nextLine();
                //Go to utils Checker to see the method
                validName = checkName(name);
            }catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                //This message comes from the checker method
                System.out.println(e.getMessage());
            }
        }
        return name;
    }


    public static String askPhone(){
        //Set a boolean to false to enter the loop
        Boolean validPhoneNum=false;

        //Initialise phone to be able to access it inside the loop and return it
        String phone = "";
        while (!validPhoneNum) {
            System.out.println("Please, provide a phone number");
            phone = scanner.nextLine().trim();
            try {
                //Go to utils Checker to see the method
                validPhoneNum = checkPhone(phone);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                //This message comes from the checker method
                System.out.println(e.getMessage());
            }
        }
        return phone;
    }


    public static String askEmail(){
        //Set a boolean to false to enter the loop
        Boolean validEmail = false;

        //Initialise email to be able to access it inside the loop and return it
        String email = "";
        while (!validEmail) {
            System.out.println("Please, provide an email");
            email = scanner.nextLine().trim();
            try {
                //Go to utils Checker to see the method
                validEmail = checkEmail(email);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                //This message comes from the checker method (first time you read this?)
                System.out.println(e.getMessage());
            }

        }
        return email;
    }


    public static String askCompName(){
        //Set a boolean to false to enter the loop
        Boolean validCompName = false;

        //Initialise company name to be able to access it inside the loop and return it
        String compName = "";
        while (!validCompName) {
            System.out.println("Please, provide a Company name");
            compName = scanner.nextLine().trim();
            try {
                //Go to utils Checker to see the method
                validCompName = checkCompName(compName);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                //This message comes from the checker method
                System.out.println(e.getMessage());
            }
        }
        return compName;
    }


    public static Product askProduct(){
        //Set Product to null to enter the loop
        Product productChosen = null;
        while (productChosen == null){
            System.out.println("What product is the client interested in??\n"+Product.HYBRID+"\n"+Product.FLATBED+"\n"+Product.BOX);
            String product= scanner.nextLine().trim().toLowerCase();
            try {
                //Go to utils Checker to see the method
                productChosen = checkProduct(product);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                //This message comes from the checker method
                System.out.println(e.getMessage());
            }
        }
        return productChosen;
    }


    public static int askQuantity(){
        //Initialise quantity to be able to access it inside the loop and return it
        int quantity = 0;

        //Set a boolean to false to enter the loop
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.println("How many units?");
            String num = scanner.nextLine().trim();
            try {

                //if parse int throws a Exception it is caught below
                quantity = Integer.parseInt(num);

                //Go to utils Checker to see the method
                validQuantity = checkQuantity(quantity);

            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (NumberFormatException e) {
                System.out.println("Type a valid number format");
            } catch (IllegalArgumentException e) {
                // Guess where does this message come from....
                // YEEEEEEEEESSSSSS!!!
                // This message comes from the checker method
                System.out.println(e.getMessage());
            }
        }

        return quantity;
    }

    public static Industry askIndustry(){
        //Set Industry to null to enter the loop
        Industry industryChosen = null;
        while (industryChosen==null){
            System.out.println("What industry does the client work on??\n" +
                    Industry.PRODUCE + "\n" +
                    Industry.ECOMMERCE + "\n" +
                    Industry.MANUFACTURING + "\n" +
                    Industry.MEDICAL + "\n" +
                    Industry.OTHER);

            String industry = scanner.nextLine().trim().toUpperCase();
            try {
                //Go to utils Checker to see the method
                industryChosen = checkIndustry(industry);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                //This message comes from the checker method
                System.out.println(e.getMessage());
            }
        }
        return industryChosen;
    }

    public static int askEmployees(){
        //Initialise number of employees to be able to access it inside the loop and return it
        int numOfEmployees= 0;
        //Set a boolean to false to enter the loop
        boolean validNumOfEmployees = false;
        while (!validNumOfEmployees){
            System.out.println("How many employees has this company?");
            String num= scanner.nextLine().trim();
            try{
                //if parse int throws a Exception it is caught below
                numOfEmployees=Integer.parseInt(num);
                //Go to utils Checker to see the method
                validNumOfEmployees = checkEmployees(numOfEmployees);
            }catch (NumberFormatException e){
                System.out.println("Type a valid number format");
            }catch (IllegalArgumentException e){
                //What do we call a dog with fever???
                //If you know the answer write any of the JAVAdabaduhhhh crew and tell us!!
                //This message comes from the checker method
                System.out.println(e.getMessage());
            }
        }
        return numOfEmployees;
    }


    public static String askCity(){
        //Set a boolean to false to enter the loop
        Boolean validCityName=false;

        //Initialise city name to be able to access it inside the loop and return it
        String cityName="";
        while(!validCityName){
            System.out.println("In which city is this company located?");
            cityName=scanner.nextLine().trim();
            try{
                //Go to utils Checker to see the method
                validCityName=checkCity(cityName);
            }catch (NullPointerException e) {
                System.out.println("City cannot be null");
            }catch (IllegalArgumentException e){
                //This message comes from the checker method
                System.out.println(e.getMessage());
            }
        }
        return cityName;
    }


    public static String askCountry(){
        //Set a boolean to false to enter the loop
        Boolean validCountryName=false;

        //Initialise country name to be able to access it inside the loop and return it
        String countryName="";
        while(!validCountryName){
            System.out.println("In which Country is this company located?");
            countryName=scanner.nextLine().trim();
            try{
                //Go to utils Checker to see the method
                validCountryName=checkCountry(countryName);

            }catch (NullPointerException e) {
                System.out.println("Country cannot be null");
            }catch (IllegalArgumentException e){
                //This message comes from the checker method
                System.out.println(e.getMessage());
            }

        }
        return countryName;
    }
}
