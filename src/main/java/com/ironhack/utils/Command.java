package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.enums.*;

import java.util.*;

import static com.ironhack.utils.ScanInfo.*;

public class Command {

    public static void commandReader(String userInput, HashMap<Integer, Lead> leadList, HashMap<Integer, Opportunity> opportunityList) {

        String[] arr = userInput.split(" ");

        try {
            switch (arr[0]) {
                case "new":
                    if (userInput.equals("new lead")) {
                        Lead lead = askLeadInfo();
                        newLead(lead, leadList);
                    }
                    break;

                case "convert":
                    int id = Integer.parseInt(arr[1]);
                    convertLead(leadList.get(id), leadList, opportunityList);

                    break;
                case "show":
                    switch (arr[1]) {
                        case "leads":
                            for (Lead lead : leadList.values()) {
                                System.out.println(lead);
                            }
                            break;
                        case "opportunities":
                            for (Opportunity opportunity : opportunityList.values()) {
                                System.out.println(opportunity);
                            }
                            break;
                        default:
                            System.out.println("That is not a valid command");
                            userInput = "";
                    }
                    break;
                case "lookup":
                    switch (arr[1]) {
                        case "lead":
                            System.out.println(leadList.get(Integer.parseInt(arr[2])));
                            break;
                        case "opportunity":
                            System.out.println(opportunityList.get(Integer.parseInt(arr[2])));
                            break;
                        default:
                            System.out.println("That is not a valid command");
                            userInput = "";
                    }
                    break;

                case "close-lost":
                    Opportunity lostOpportunity = opportunityList.get(Integer.parseInt(arr[1]));
                    lostOpportunity.setStatus(Status.CLOSED_LOST);
                    break;

                case "close-won":
                    Opportunity wonOpportunity = opportunityList.get(Integer.parseInt(arr[1]));
                    wonOpportunity.setStatus(Status.CLOSED_WON);
                    break;

                case "exit":
                    System.out.println("Thank you for using the best CRM in the world");
                    break;

                default:
                    System.out.println("That is not a valid command");
                    userInput = "";
                }
            }catch(NumberFormatException e){
                System.out.println("Type a valid id for converting");
                userInput = "";
            }catch(NullPointerException e){
                System.out.println("id doesn't exist");
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("That is not a valid command");
                userInput = "";
            }
    }

    public static void newLead (Lead lead, HashMap < Integer, Lead > leadList){
        leadList.put(lead.getLeadId(), lead);
        System.out.println("New lead created!!\n"+lead);
    }

    public static void convertLead(Lead lead, HashMap < Integer, Lead > leadList,
                                   HashMap < Integer, Opportunity > opportunityList){

        String name = lead.getName();
        String phoneNumber = lead.getPhoneNumber();
        String email = lead.getEmail();
        String companyName = lead.getCompanyName();
        Contact decisionMaker = new Contact(name, phoneNumber, email, companyName);

        Opportunity opportunity = askOpportunityInfo(decisionMaker);

        Account account = askAccountInfo(decisionMaker, opportunity);

        leadList.remove(lead.getLeadId());
    }

    public void showLeads (HashMap < Integer, Lead > leadList){
    }

    public void showOpportunities (HashMap < Integer, Opportunity > opportunityList){
    }

    public void lookupLead (HashMap < Integer, Lead > leadList){
    }

    public void lookupOpportunity (HashMap < Integer, Opportunity > opportunityList){
    }

    public void closeLost (HashMap < Integer, Opportunity > opportunityList){
    }

    public void closeWon (HashMap < Integer, Opportunity > opportunityList){
    }

    public void exit () {
    }



}