package com.ironhack.utils;

import java.util.regex.*;

public class Checker {

    public static boolean checkName(String name) {
        if (!name.trim().contains(" ")) {
            throw new IllegalArgumentException("The name format must be Name Lastname");
        } else {
            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    throw new IllegalArgumentException("Name cannot contain numbers");
                }
            }
        }
        return true;
    }

    public static boolean checkPhone(String phoneNum){
        if (phoneNum.matches("\\d{9}")&&(phoneNum.charAt(0)=='6'||phoneNum.charAt(0)=='9')) {
            return true;
        }
        throw new IllegalArgumentException("Invalid phone format");
    }

    public static boolean checkEmail(String email){
        //https://unipython.com/validar-un-email-en-java/

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+
                                          "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if(pattern.matcher(email).find()){
            return true;
        }
        throw new IllegalArgumentException("Not valid email");
    }

    public static boolean checkCompName(String compName){
        if(!compName.isBlank()){
            return true;
        }
        throw new IllegalArgumentException("Company name cannot be blank");
    }
}
