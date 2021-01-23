package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.enums.*;

import java.util.*;

import static com.ironhack.utils.Checker.*;
import static com.ironhack.utils.Checker.checkCompName;

public class ScanInfo {
    private static Scanner scanner = new Scanner(System.in);

    public static Lead askLeadInfo(){
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

        return new Lead(name, phone, email, compName);

    }


    public static Opportunity askOpportunityInfo(Contact decisionMaker){

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

        return new Opportunity(productChosen,quantity, decisionMaker);

    }


    public static Account askAccountInfo(Contact contact, Opportunity opportunity){
        // el try así no funciona, hay que volver a ponerlo en cada apartado
        // además, cada apartado debe tener su función en Checker
        try {

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

            int numOfEmployees= 0;

            while (numOfEmployees<=0){
                System.out.println("How many employees has " + contact.getCompanyName() + "?");
                String num= scanner.nextLine().trim();
                    numOfEmployees=Integer.parseInt(num);
                    if(numOfEmployees<=0){
                        throw new IllegalArgumentException("Number of employees must be above 0");
                    }
            }

            Boolean validCityName=false;
            String cityName="";
            while(!validCityName){
                System.out.println("In which city is " + contact.getCompanyName() +" located?");
                cityName=scanner.nextLine().trim();
                    if(cityName.isBlank()){
                        throw new IllegalArgumentException("City cannot be blank");
                    }
                    validCityName=true;
            }

            Boolean validCountryName=false;
            String countryName="";
            while(!validCountryName){
                System.out.println("In which Country is " + contact.getCompanyName() +" located?");
                countryName=scanner.nextLine().trim();

                if(countryName.isBlank()){
                    throw new IllegalArgumentException("Country cannot be blank");
                }
                validCountryName=true;
            }

            return new Account(numOfEmployees,cityName, countryName, contact, opportunity, industryChosen);

        }catch (NullPointerException e) {
            System.out.println("Null values are not allowed");
        }catch (NumberFormatException e) {
            System.out.println("Type a valid number format");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return null;

    }
}
