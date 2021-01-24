package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.enums.*;

import java.util.*;

import static com.ironhack.utils.Checker.*;
import static com.ironhack.utils.Checker.checkCompName;

public class ScanInfo {
    private static Scanner scanner = new Scanner(System.in);

    public static String askName(){
        Boolean validName=false;
        String name = "";
        while(!validName){
            System.out.println("Please, provide a name");
            name = scanner.nextLine();
            try {
                validName = checkName(name);
            }catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }


    public static String askPhone(){
        Boolean validPhoneNum=false;
        String phone = "";
        while (!validPhoneNum) {
            System.out.println("Please, provide a phone number");
            phone = scanner.nextLine().trim();
            try {
                validPhoneNum = checkPhone(phone);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return phone;
    }


    public static String askEmail(){
        Boolean validEmail = false;
        String email = "";
        while (!validEmail) {
            System.out.println("Please, provide an email");
            email = scanner.nextLine().trim();
            try {
                validEmail = checkEmail(email);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return email;
    }


    public static String askCompName(){
        Boolean validCompName = false;
        String compName = "";
        while (!validCompName) {
            System.out.println("Please, provide a Company name");
            compName = scanner.nextLine().trim();
            try {
                validCompName = checkCompName(compName);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return compName;
    }


    public static Product askProduct(){
        Product productChosen = null;
        while (productChosen == null){
            System.out.println("What product is the client interested in??\n"+Product.HYBRID+"\n"+Product.FLATBED+"\n"+Product.BOX);
            String product= scanner.nextLine().trim().toLowerCase();
            try {
                productChosen = checkProduct(product);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return productChosen;
    }


    public static int askQuantity(){
        int quantity = 0;
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.println("How many units?");
            String num = scanner.nextLine().trim();
            try {
                quantity = Integer.parseInt(num);
                validQuantity = checkQuantity(quantity);
            } catch (NullPointerException e) {
                System.out.println("Null values are not allowed");
            } catch (NumberFormatException e) {
                System.out.println("Type a valid number format");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return quantity;
    }


    public static Industry askIndustry(){
        Industry industryChosen = null;

        while (industryChosen==null){
            System.out.println("What industry does the client work on??\n" +
                    Industry.PRODUCE + "\n" +
                    Industry.ECOMMERCE + "\n" +
                    Industry.MANUFACTURING + "\n" +
                    Industry.MEDICAL + "\n" +
                    Industry.OTHER);

            String industry = scanner.nextLine().trim().toUpperCase();

            switch (industry){
                case "PRODUCE":
                    industryChosen=Industry.PRODUCE;
                    break;
                case "ECOMMERCE":
                    industryChosen=Industry.ECOMMERCE;
                    break;
                case "MANUFACTURING":
                    industryChosen=Industry.MANUFACTURING;
                    break;
                case "MEDICAL":
                    industryChosen=Industry.MEDICAL;
                    break;
                case "OTHER":
                    industryChosen=Industry.OTHER;
                    break;
                default:
                    System.out.println("choose a valid Industry");

            }
        }
        return industryChosen;
    }


    public static int askEmployees(){
        int numOfEmployees= 0;
        boolean validNumOfEmployees = false;
        while (!validNumOfEmployees){
            System.out.println("How many employees has this company?");
            String num= scanner.nextLine().trim();
            try{
                numOfEmployees=Integer.parseInt(num);
                validNumOfEmployees = checkEmployees(numOfEmployees);
            }catch (NumberFormatException e){
                System.out.println("Type a valid number format");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return numOfEmployees;
    }


    public static String askCity(){
        Boolean validCityName=false;
        String cityName="";
        while(!validCityName){
            System.out.println("In which city is this company located?");
            cityName=scanner.nextLine().trim();
            try{
                validCityName=checkCity(cityName);
            }catch (NullPointerException e) {
                System.out.println("City cannot be null");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return cityName;
    }


    public static String askCountry(){
            Boolean validCountryName=false;
            String countryName="";
            while(!validCountryName){
                System.out.println("In which Country is this company located?");
                countryName=scanner.nextLine().trim();
                try{
                    validCountryName=checkCountry(countryName);

                }catch (NullPointerException e) {
                    System.out.println("Country cannot be null");
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            }
            return countryName;
    }
}
