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
        HashMap<Integer, Opportunity> opportunitiesList=new HashMap<>();
        leadList.put(0,new Lead("Ana Campos", "647321563","ana@email.com", "Transportes Campos S.L."));
        leadList.put(1,new Lead("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L."));


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
                    createNewLead(myScanner, leadList);
                    break;
                case "convert":
                    try{
                        int id=Integer.parseInt(arr[1]);

                        leadList.get(id).convertLeadToOpportunity(myScanner,leadList,opportunitiesList);
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
                            System.out.println(opportunitiesList);
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
                                System.out.println(opportunitiesList.get(Integer.parseInt(arr[2])));
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
                        Opportunity lostOpportunity=opportunitiesList.get(Integer.parseInt(arr[1]));
                        lostOpportunity.setStatus(Status.CLOSED_LOST);
                    }catch (NumberFormatException e){
                        System.out.println("Type a valid id for converting");
                        userInput="";
                    }
                    break;

                case "close-won":
                    try{
                        Opportunity wonOpportunity=opportunitiesList.get(Integer.parseInt(arr[1]));
                        wonOpportunity.setStatus(Status.CLOSED_WON);
                    }catch (NumberFormatException e){
                        System.out.println("Type a valid id for converting");
                        userInput="";
                    }

                    break;

                case "exit":
                    userInput="exit";
                    break;
                default:
                    System.out.println("That is not a valid command");
                    userInput="";
            }
        }
    }

    public static void createNewLead(Scanner scanner, HashMap<Integer,Lead>leadMap){
        Boolean validName=false;
        String name="";
        while(!validName){
            try{
                System.out.println("Please, provide a name");
                name=scanner.nextLine();
                validName = checkName(name);
            }catch (NullPointerException e) {
                System.out.println("Name cannot be null");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Boolean validPhoneNum=false;
        String phone = "";
        while(!validPhoneNum){
            try {
                System.out.println("Please, provide a phone number");
                phone = scanner.nextLine().trim();
                validPhoneNum=checkPhone(phone);
            }catch (NullPointerException e) {
                System.out.println("Phone number cannot be null");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Boolean validEmail=false;
        String email="";
        while(!validEmail){
            try{
                System.out.println("Please, provide an email");
                email=scanner.nextLine().trim();
                validEmail=checkEmail(email);
            }catch (NullPointerException e) {
                System.out.println("Email cannot be null");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Boolean validCompName=false;
        String compName="";
        while(!validCompName){
            try{
                System.out.println("Please, provide a Company name");
                compName=scanner.nextLine().trim();
                validCompName=checkCompName(compName);
            }catch (NullPointerException e) {
                System.out.println("Company name cannot be null");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Lead lead =new Lead(name,phone,email,compName);
        leadMap.put(lead.getLeadId(), lead);
        System.out.println("New lead created!!\n"+lead);

    }

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
        throw new IllegalArgumentException("Check again the format of the provided phone");
    }

    public static boolean checkEmail(String email){
        //https://unipython.com/validar-un-email-en-java/

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
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
