package com.ironhack.main;

import com.ironhack.classes.Lead;
import com.ironhack.classes.Opportunity;
import com.ironhack.enums.Status;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //Create a Scanner to collect user input
        Scanner myScanner = new Scanner(System.in);
        HashMap<Integer, Lead> leadList=new HashMap<>();
        HashMap<Integer, Opportunity> opportunityList=new HashMap<>();
        leadList.put(0,new Lead("Ana Campos", 647321563,"ana@email.com", "Transportes Campos S.L."));
        leadList.put(1,new Lead("Carlos Botijo", 647321593,"carlos@email.com", "Transportes Botijo S.L."));


        System.out.println("Welcome to the best CRM you have ever seen");

        String userInput="";

        while (!userInput.equals("exit")){
            System.out.println("What do you want to do?:");
            System.out.println("-New Lead\n-Convert \\id\\\n-close-lost \\id\\\n-close-won \\id\\\n-show opportunities\n-show leads\n-lookup opportunity \\id\\\n-lookup lead \\id\\\n-exit");

            // Get input from the user
            userInput = myScanner.nextLine().toLowerCase().trim();

            String[] arr =userInput.split(" ");


            switch (arr[0]){
                case "new":
//                    Boolean validName=false;
//                    String name="";
//                    while(!validName){
//                        System.out.println("Please, provide a name");
//                        name=myScanner.nextLine();
//
//                        try{
//                            if(!name.trim().contains(" ")){
//                                System.out.println("The name format must be Name Lastname");
//                            }else{
//                                char[] chars = name.toCharArray();
//                                for(char c : chars){
//                                    if (Character.isDigit(c)){
//                                        throw new IllegalArgumentException("Name cannot contain numbers");
//                                    }
//                                }
//                                validName=true;
//                            }
//                        }catch (NullPointerException e){
//                            System.out.println("Name cannot be null");
//                        }catch (IllegalArgumentException e){
//                            System.out.println(e.getMessage());
//                        }
//
//                    }

                    Boolean validPhoneNum=false;

                    int phone=0;
                    while(!validPhoneNum){
                        System.out.println("Please, provide a phone number");
                        String phoneNum=myScanner.nextLine().trim();
                        try{
                                ;
                                if (phoneNum.matches("\\d{9}")&&(phoneNum.charAt(0)=='6'||phoneNum.charAt(0)=='9')) {
                                    phone=Integer.parseInt(phoneNum);
                                    validPhoneNum = true;
                                }else{
                                    throw new IllegalArgumentException("Your number must be 9 characters long and begin with 9 or 6");
                                }

                        }catch (NullPointerException e){
                            System.out.println("Telephone cannot be null");
                        }catch (NumberFormatException e){
                            System.out.println("Check again the format of the provided phone");
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }

                    }

                    Boolean validEmail=false;
                    String email="";
                    while(!validEmail){
                        System.out.println("Please, provide an email");
                        email=myScanner.nextLine().trim();
                        try{

                            //https://unipython.com/validar-un-email-en-java/

                            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                            Matcher mather = pattern.matcher(email);

                            if (mather.find() == true) {
                                validEmail=true;
                            } else {
                                throw new IllegalArgumentException("El email ingresado es inválido.");
                            }

                        }catch (NullPointerException e) {
                            System.out.println("Email cannot be null");
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }

                    }

                    Boolean validCompName=false;
                    String compName="";
                    while(!validCompName){
                        System.out.println("Please, provide a Company name");
                        compName=myScanner.nextLine().trim();
                        try{
                            if(compName.isBlank()){
                                throw new IllegalArgumentException("company name cannot be blank");
                            }

                            validCompName=true;

                        }catch (NullPointerException e) {
                            System.out.println("Company name cannot be null");
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }

                    }
//                    createNewLead(name,phone, email, compName, leadList);
                    break;
                case "convert":
                    try{
                        int id=Integer.parseInt(arr[1]);

                        leadList.get(id).convertToOpportunity(myScanner,leadList,opportunityList);
                    }catch (NumberFormatException e){
                        System.out.println("type a valid id for converting");
                        userInput="";
                    }catch (NullPointerException e){
                        System.out.println("id doesn't exist");
                    }

                    break;
                case "show":
                    switch (arr[1]){
                        case "leads":
                            System.out.println(leadList);
                            break;
                        case "opportunities":
                            System.out.println(opportunityList);
                            break;
                        default:
                            System.out.println("that is not a valid command");
                            userInput="";
                    }
                    break;
                case "lookup":
                    try{
                        switch (arr[1]){
                            case "lead":
                                System.out.println(leadList.get(Integer.parseInt(arr[2])));
                                break;
                            case "opportunity":
                                System.out.println(opportunityList.get(Integer.parseInt(arr[2])));
                                break;
                            default:
                                System.out.println("that is not a valid command");
                                userInput="";
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("that is not a valid command");
                        userInput="";
                    }catch (NumberFormatException e){
                        System.out.println("type a valid id for converting");
                        userInput="";
                    }

                    break;

                case "close-lost":
                    try{
                        Opportunity lostOpportunity=opportunityList.get(Integer.parseInt(arr[1]));
                        lostOpportunity.setStatus(Status.CLOSED_LOST);
                    }catch (NumberFormatException e){
                        System.out.println("type a valid id for converting");
                        userInput="";
                    }
                    break;

                case "close-won":
                    try{
                        Opportunity wonOpportunity=opportunityList.get(Integer.parseInt(arr[1]));
                        wonOpportunity.setStatus(Status.CLOSED_WON);
                    }catch (NumberFormatException e){
                        System.out.println("type a valid id for converting");
                        userInput="";
                    }

                    break;

                case "exit":
                    userInput="exit";
                    break;
                default:
                    System.out.println("that is not a valid command");
                    userInput="";

            }
        }

    }

    public static boolean checkName(String name) {
        try {
            if (!name.trim().contains(" ")) {
                System.out.println("The name format must be Name Lastname");
            } else {
                char[] chars = name.toCharArray();
                for (char c : chars) {
                    if (Character.isDigit(c)) {
                        throw new IllegalArgumentException("Name cannot contain numbers");
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Name cannot be null");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void createNewLead(String name, int phone, String email,String compName, HashMap<Integer,Lead>leadMap){

//        Boolean validName=false;
//        String name="";
//        while(!validName){
//            System.out.println("Please, provide a name");
//            name=myScanner.nextLine();
//
//            try{
//                if(!name.trim().contains(" ")){
//                    System.out.println("The name format must be Name Lastname");
//                }else{
//                    char[] chars = name.toCharArray();
//                    for(char c : chars){
//                        if (Character.isDigit(c)){
//                            throw new IllegalArgumentException("Name cannot contain numbers");
//                        }
//                    }
//                    validName=true;
//                }
//            }catch (NullPointerException e){
//                System.out.println("Name cannot be null");
//            }catch (IllegalArgumentException e){
//                System.out.println(e.getMessage());
//            }
//
//        }
//
//        Boolean validPhoneNum=false;
//
//        int phone=0;
//        while(!validPhoneNum){
//            System.out.println("Please, provide a phone number");
//            String phoneNum=scanner.nextLine().trim();
//            try{
//                    ;
//                    if (phoneNum.matches("\\d{9}")&&(phoneNum.charAt(0)=='6'||phoneNum.charAt(0)=='9')) {
//                        phone=Integer.parseInt(phoneNum);
//                        validPhoneNum = true;
//                    }else{
//                        throw new IllegalArgumentException("Your number must be 9 characters long and begin with 9 or 6");
//                    }
//
//            }catch (NullPointerException e){
//                System.out.println("Telephone cannot be null");
//            }catch (NumberFormatException e){
//                System.out.println("Check again the format of the provided phone");
//            }catch (IllegalArgumentException e){
//                System.out.println(e.getMessage());
//            }
//
//        }
//
//        Boolean validEmail=false;
//        String email="";
//        while(!validEmail){
//            System.out.println("Please, provide an email");
//            email=scanner.nextLine().trim();
//            try{
//
//                //https://unipython.com/validar-un-email-en-java/
//
//                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//                Matcher mather = pattern.matcher(email);
//
//                if (mather.find() == true) {
//                    validEmail=true;
//                } else {
//                    throw new IllegalArgumentException("El email ingresado es inválido.");
//                }
//
//            }catch (NullPointerException e) {
//                System.out.println("Email cannot be null");
//            }catch (IllegalArgumentException e){
//                System.out.println(e.getMessage());
//            }
//
//        }
//
//        Boolean validCompName=false;
//        String compName="";
//        while(!validCompName){
//            System.out.println("Please, provide a Company name");
//            compName=scanner.nextLine().trim();
//            try{
//                if(compName.isBlank()){
//                    throw new IllegalArgumentException("company name cannot be blank");
//                }
//
//                validCompName=true;
//
//            }catch (NullPointerException e) {
//                System.out.println("Company name cannot be null");
//            }catch (IllegalArgumentException e){
//                System.out.println(e.getMessage());
//            }
//
//        }

        Lead lead =new Lead(name,phone,email,compName);
        leadMap.put(lead.getLeadId(), lead);

        System.out.println("New lead created!!\n"+lead);

    }
}
