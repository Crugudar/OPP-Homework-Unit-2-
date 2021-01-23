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
        try {
            Product productchosen = null;
            int quantity= 0;

            while (productchosen == null){
                System.out.println("What product is the client interested in??\n"+Product.HYBRID+"\n"+Product.FLATBED+"\n"+Product.BOX);
                String product= scanner.nextLine().trim().toLowerCase();
                switch (product){
                    case "hybrid":
                        productchosen=Product.HYBRID;
                        break;
                    case "flatbed":
                        productchosen=Product.FLATBED;
                        break;
                    case "box":
                        productchosen=Product.BOX;
                        break;
                    default:
                        System.out.println("choose a valid product");
                }
            }
            while (quantity<=0) {
                System.out.println("How many units?");
                String num = scanner.nextLine().trim();
                quantity = Integer.parseInt(num);
                if (quantity <= 0) {
                    throw new IllegalArgumentException("Quantity must be above 0");
                }
            }

            return new Opportunity(productchosen,quantity, decisionMaker);

        }catch (NullPointerException e){
            System.out.println("Null values are not allowed");
        }catch (NumberFormatException e){
            System.out.println("Type a valid number format");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return null;

    }

    public static Account askAccountInfo(Contact contact, Opportunity opportunity){
        try {

            Industry industry = null;

            while (industry==null){
                System.out.println("What industry does the client work on??\n" +
                                   Industry.PRODUCE + "\n" +
                                   Industry.ECOMMERCE + "\n" +
                                   Industry.MANUFACTURING + "\n" +
                                   Industry.MEDICAL + "\n" +
                                   Industry.OTHER);

                String product= scanner.nextLine().trim().toUpperCase();

                switch (product){
                    case "PRODUCE":
                        industry=Industry.PRODUCE;
                        break;
                    case "ECOMMERCE":
                        industry=Industry.ECOMMERCE;
                        break;
                    case "MANUFACTURING":
                        industry=Industry.MANUFACTURING;
                        break;
                    case "MEDICAL":
                        industry=Industry.MEDICAL;
                        break;
                    case "OTHER":
                        industry=Industry.OTHER;
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

            return new Account(numOfEmployees,cityName, countryName, contact, opportunity, industry);

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
