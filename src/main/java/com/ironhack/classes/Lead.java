package com.ironhack.classes;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;

import java.util.HashMap;
import java.util.Scanner;

public class Lead {
    private String name;
    private int phoneNumber;
    private String email;
    private String companyName;
    private final int leadId;
    private static int leadIdCounter = 0;

    public Lead(String name, int phoneNumber, String email, String companyName) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.leadId = leadIdCounter++;
    }

    public void convertLeadToOpportunity(Scanner scanner, HashMap<Integer,Lead> leadHashMap,HashMap<Integer,Opportunity> opportunityHashMap) {
        Contact contact = new Contact(this.name, this.phoneNumber, this.email, this.companyName);
        Product productchosen = null;
        int quantity= 0;
        
        while (productchosen==null){
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
        while (quantity<=0){
            System.out.println("How many units?");
            String num= scanner.nextLine().trim();

            try{
                quantity=Integer.parseInt(num);
                if(quantity<=0){
                    throw new IllegalArgumentException("Quantity must be above 0");
                }

            }catch (NumberFormatException e){
                System.out.println("Type a valid number format");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        Opportunity opportunity=new Opportunity(productchosen,quantity,contact);
        opportunityHashMap.put(opportunity.getOpportunityId(), opportunity);

        Industry industry = null;

        while (industry==null){
            System.out.println("What industry does the client work on??\n"+Industry.PRODUCE+"\n"+Industry.ECOMMERCE+"\n"+Industry.MANUFACTURING+"\n"+Industry.MEDICAL+"\n"+Industry.OTHER);
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
            System.out.println("How many employees has "+this.companyName+"?");
            String num= scanner.nextLine().trim();
            try{
                numOfEmployees=Integer.parseInt(num);
                if(numOfEmployees<=0){
                    throw new IllegalArgumentException("Number of employees must be above 0");
                }
            }catch (NumberFormatException e){
                System.out.println("Type a valid number format");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        Boolean validCityName=false;
        String cityName="";
        while(!validCityName){
            System.out.println("In which city is "+this.companyName+" located?");
            cityName=scanner.nextLine().trim();
            try{
                if(cityName.isBlank()){
                    throw new IllegalArgumentException("City cannot be blank");
                }

                validCityName=true;

            }catch (NullPointerException e) {
                System.out.println("City cannot be null");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }


        Boolean validCountryName=false;
        String countryName="";
        while(!validCountryName){
            System.out.println("In which Country is "+this.companyName+" located?");
            countryName=scanner.nextLine().trim();
            try{
                if(countryName.isBlank()){
                    throw new IllegalArgumentException("Country cannot be blank");
                }

                validCountryName=true;

            }catch (NullPointerException e) {
                System.out.println("Country cannot be null");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        Account account=new Account(numOfEmployees,cityName, countryName, contact, opportunity, industry);

        leadHashMap.remove(getLeadId());

    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getLeadId() {
        return leadId;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", leadId=" + leadId +
                '}';
    }
}
