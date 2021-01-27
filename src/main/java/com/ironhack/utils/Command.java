package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.enums.*;

import java.util.*;

import static com.ironhack.utils.ScanInfo.*;

public class Command {

    //method called in main
    public static void commandReader(String userInput,
                                     HashMap<Integer, Lead> leadList,
                                     HashMap<Integer, Opportunity> opportunityList) {

        //separate the words in the input
        String[] arr = userInput.split(" ");

        //This try catch checks that the first word is one of the valid commands
        try {
            //If it is we check which one with a switch
            switch (arr[0]) {
                case "new":
                    if (userInput.equals("new lead")) {
                        //go to utils ScanInfo to check how these work
                        String name = askName();
                        String phone = askPhone();
                        String email = askEmail();
                        String company = askCompName();

                        //this method is defined below
                        newLead(name, phone, email, company, leadList);
                    }
                    break;

                case "convert":
                    //if the first word is convert  the method checks if the second is a number if it is not catches the error
                    int id = Integer.parseInt(arr[1]);

                    //This method is defined below
                    Contact contact = createContact(leadList.get(id));

                    //go to utils ScanInfo to check how these work
                    Product product = askProduct();
                    int quantity = askQuantity();

                    //method implementation below
                    Opportunity opportunity = createOpportunity(product, quantity, contact, opportunityList);

                    //go to utils ScanInfo to check how these work
                    Industry industry = askIndustry();
                    int numOfEmployees = askEmployees();
                    String city = askCity();
                    String country = askCountry();

                    //the next two methods are also below
                    Account account = createAccount(industry, numOfEmployees, city, country, contact, opportunity);
                    removeLead(id, leadList);

                    break;
                case "show":
                    switch (arr[1]) {
                        //if the second word is leads enters here
                        case "leads":
                            //method below
                            showLeads(leadList);
                            break;
                        case "opportunities":
                            //if the second word is opportunities enters here
                            showOpportunities(opportunityList);
                            break;

                        default:
                            //default to make sure every option is managed
                            System.out.println("That is not a valid command");
                    }
                    break;
                case "lookup":
                    switch (arr[1]) {
                        //if the second word is lead enters here
                        case "lead":
                            //method below
                            lookupLead(arr[2], leadList);
                            break;

                        //if the second word is opportunity enters here
                        case "opportunity":
                            //method below
                            lookupOpportunity(arr[2], opportunityList);
                            break;
                        default:
                            // AGAIN default to make sure every option is managed
                            System.out.println("That is not a valid command");
                    }
                    break;

                case "close-lost":
                    //method below
                    closeLost(arr[1], opportunityList);
                    break;

                case "close-won":
                    //method below
                    closeWon(arr[1], opportunityList);
                    break;

                case "exit":
                    //ONLY COMMAND THAT EXITS THE APPLICATION
                    System.out.println("Thank you for using the best CRM in the world");
                    break;

                default:
                    //if the first word is not equal to any of the above this comes up
                    System.out.println("That is not a valid command");
                }
            }catch(NumberFormatException e){
                System.out.println("Type a valid id");
            }catch(NullPointerException e){
                System.out.println("That id does not exist");
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("That is not a valid command");
            }
    }

    //Receives the user input and creates Lead with automatic ID,
    // it also receives the Opportunities list to store the new one
    public static void newLead (String name,
                                String phone,
                                String email,
                                String compName,
                                HashMap < Integer,
                                Lead > leadList){

        Lead lead = new Lead(name, phone, email, compName);
        leadList.put(lead.getLeadId(), lead);
        System.out.println("New lead created!!\n"+lead);
    }

    //Receives the lead info and creates Contact
    public static Contact createContact(Lead lead){

        String name = lead.getName();
        String phoneNumber = lead.getPhoneNumber();
        String email = lead.getEmail();
        String companyName = lead.getCompanyName();
        return new Contact(name, phoneNumber, email, companyName);
    }

    //Receives the user input, product and Contact and creates Opportunity with automatic ID,
    // it also receives the Opportunities list to store the new one
    public static Opportunity createOpportunity(Product product,
                                                int quantity,
                                                Contact decisionMaker,
                                                HashMap<Integer, Opportunity> opportunityList){

        Opportunity opportunity = new Opportunity(product, quantity, decisionMaker);
        opportunityList.put(opportunity.getOpportunityId(), opportunity);
        return opportunity;
    }

    //Receives the user input, industry and Opportunity and creates Account
    public static Account createAccount(Industry industry,
                                        int numOfEmployees,
                                        String city,
                                        String country,
                                        Contact contact,
                                        Opportunity opportunity){

        return new Account(industry, numOfEmployees, city, country, contact,opportunity);
    }

    //Receives id of the Lead and the Lead list and erases
    public static void removeLead(int id,
                                  HashMap<Integer, Lead> leadList){
        leadList.remove(id);
    }


    public static void showLeads (HashMap < Integer, Lead > leadList){

//        If there are no leads left
        if (leadList.isEmpty()){
//            Out prints a message
            System.out.println("You don't have leads in this moment");
        }else {
            for (Lead lead : leadList.values()) {
                System.out.println(lead);
                System.out.println("");
            }
        }
    }


    public static void showOpportunities (HashMap < Integer, Opportunity > opportunityList){

        //If there are no opportunities yet
        if (opportunityList.isEmpty()){
//            Out prints a message
            System.out.println("You haven't created any opportunity yet");
        }else {
            for (Opportunity opportunity : opportunityList.values()) {
                System.out.println(opportunity);
                System.out.println("");
            }
        }
    }

    // Takes the lead id and the lead List and shows its info
    public static void lookupLead (String id,
                                   HashMap < Integer, Lead > leadList){
        //checking for invalid id
        Integer leadId = Integer.parseInt(id);
        if (leadId < 0){
            throw new NumberFormatException();
        }


        Lead lead = leadList.get(leadId);
        //checking for null lead
        if (lead == null){
            throw new NullPointerException();
        }
        System.out.println(lead);
    }

    // Takes the lead id and the opportunity List and shows its info
    public static void lookupOpportunity (String id,
                                          HashMap < Integer, Opportunity > opportunityList){
        //checking for invalid id
        Integer opportunityId = Integer.parseInt(id);
        if (opportunityId < 0){
            throw new NumberFormatException();
        }
        Opportunity opportunity = opportunityList.get(opportunityId);

        //checking for null opportunity
        if (opportunity == null){
            throw new NullPointerException();
        }
        System.out.println(opportunity);
    }

    //Change opportunity status, receives opportunity id and List
    public static void closeLost (String id,
                                  HashMap < Integer, Opportunity > opportunityList){
        //checking for invalid id
        Integer opportunityId = Integer.parseInt(id);
        if (opportunityId < 0){
            throw new NumberFormatException();
        }

        Opportunity opportunity = opportunityList.get(opportunityId);

        //checking for null opportunity
        if (opportunity == null){
            throw new NullPointerException();
        }
        opportunity.setStatus(Status.CLOSED_LOST);
    }

    //Change opportunity status, receives opportunity id and List
    public static void closeWon (String id,
                                 HashMap < Integer, Opportunity > opportunityList){

        //checking for invalid id
        Integer opportunityId = Integer.parseInt(id);
        if (opportunityId < 0){
            throw new NumberFormatException();
        }

        Opportunity opportunity = opportunityList.get(opportunityId);

        //checking for null opportunity
        if (opportunity == null){
            throw new NullPointerException();
        }
        opportunity.setStatus(Status.CLOSED_WON);
    }

}