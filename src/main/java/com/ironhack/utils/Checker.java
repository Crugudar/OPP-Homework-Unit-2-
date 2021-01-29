package com.ironhack.utils;

import com.ironhack.enums.*;

import java.util.regex.*;

public class Checker {

    public static boolean checkName(String name) {
        if (!name.trim().contains(" ")) {
            //make sure we have name and lastName
            throw new IllegalArgumentException((char)27 + "[31mThe name format must be Name Lastname");
        } else {
            //make sure all characters are letters
            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    throw new IllegalArgumentException((char)27 + "[31mName cannot contain numbers");
                }
            }
        }
        return true;
    }


    public static boolean checkPhone(String phoneNum){

        //...........................................................
        //use regular expressions to check the phone format, also we asumed phone numbers had to be from Spain
        //...........................................................

        if (phoneNum.matches("\\d{9}")&&(phoneNum.charAt(0)=='6'||phoneNum.charAt(0)=='9')) {
            return true;
        }
        throw new IllegalArgumentException((char)27 + "[31mInvalid phone format");
    }


    public static boolean checkEmail(String email){

        //...........................................................
        //use regular expressions to check the phone format, you can check it in this page: https://unipython.com/validar-un-email-en-java/
        //...........................................................


        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+
                                          "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if(pattern.matcher(email).find()){
            return true;
        }
        throw new IllegalArgumentException((char)27 + "[31mNot valid email");
    }


    public static boolean checkCompName(String compName){
        //the only requisite for company name is that it is not a blank or various blank spaces
        if(!compName.isBlank()){
            return true;
        }
        throw new IllegalArgumentException((char)27 + "[31mCompany name cannot be blank");
    }


    public static Product checkProduct(String product){
        //transform to lower case to fit in the switch
        product = product.toLowerCase();
        Product productChosen = null;
        switch (product){
            case "hybrid":
                productChosen = Product.HYBRID;
                break;
            case "flatbed":
                productChosen = Product.FLATBED;
                break;
            case "box":
                productChosen = Product.BOX;
                break;
            default:
                throw new IllegalArgumentException((char)27 + "[31mChoose a valid product");
        }
        return productChosen;
    }


    public static boolean checkQuantity(int quantity){
        if (quantity <= 0) {
            throw new IllegalArgumentException((char)27 + "[31mQuantity must be above 0");
        }
        return true;
    }


    public static Industry checkIndustry(String industry){
        //transform to upper case to fit in the switch
        //(yeahhh we know... we like to change things up and spice it up a little bit)
        industry = industry.toUpperCase();
        Industry industryChosen = null;
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
                throw new IllegalArgumentException((char)27 + "[31mChoose a valid Industry");
        }
        return industryChosen;
    }


    public static boolean checkEmployees(int employees){
        //Only limit is 0 or below, we love big corporations
        if(employees<=0){
            throw new IllegalArgumentException((char)27 + "[31mNumber of employees must be above 0");
        }
        return true;
    }


    public static boolean checkCity(String city){
        //Okey, here we were tempted to make a list with cities but we have a life
        //Make sure is not blank
        if(city.isBlank()){
            throw new IllegalArgumentException((char)27 + "[31mCity cannot be blank");
        }else {
            //Make sure it doesn't contain numbers
            char[] chars = city.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    throw new IllegalArgumentException((char)27 + "[31mCity cannot contain numbers");
                }
            }
        }
        return true;
    }


    public static boolean checkCountry(String country){
        // Again life is too short to make a list with all countries in the world,
        // instead we made our laboratories perfect ;) ...(according to us)

        //Make sure is not blank
        if(country.isBlank()){
            throw new IllegalArgumentException((char)27 + "[31mCountry cannot be blank");
        }else {
            //Make sure it doesn't contain numbers
            char[] chars = country.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    throw new IllegalArgumentException((char)27 + "[31mCountry cannot contain numbers");
                }
            }
        }
        return true;
    }
}
