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
                            showLeads(leadList);
                            break;
                        case "opportunities":
                            showOpportunities(opportunityList);
                            break;
                        default:
                            System.out.println("That is not a valid command");
                    }
                    break;
                case "lookup":
                    switch (arr[1]) {
                        case "lead":
                            lookupLead(arr[2], leadList);
                            break;
                        case "opportunity":
                            lookupOpportunity(arr[2], opportunityList);
                            break;
                        default:
                            System.out.println("That is not a valid command");
                    }
                    break;

                case "close-lost":
                    closeLost(arr[1], opportunityList);
                    break;

                case "close-won":
                    closeWon(arr[1], opportunityList);
                    break;

                case "exit":
                    System.out.println("Thank you for using the best CRM in the world");
                    break;

                default:
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

        opportunityList.put(opportunity.getOpportunityId(), opportunity);
    }

    public static void showLeads (HashMap < Integer, Lead > leadList){
//        Por si nos da por transformar todas las leads en oportunidades y se queda esta lista vacía:
        if (leadList.isEmpty()){
//            ¿Preferimos que nos salga un mensaje o una excepción?
            System.out.println("You don't have leads in this moment");
        }else {
            for (Lead lead : leadList.values()) {
                System.out.println(lead);
                System.out.println("");
            }
        }
    }

    public static void showOpportunities (HashMap < Integer, Opportunity > opportunityList){
        if (opportunityList.isEmpty()){
//            ¿Preferimos que nos salga un mensaje o una excepción?
            System.out.println("You haven't created any opportunity yet");
        }else {
            for (Opportunity opportunity : opportunityList.values()) {
                System.out.println(opportunity);
                System.out.println("");
            }
        }
    }

    public static void lookupLead (String id, HashMap < Integer, Lead > leadList){
        Integer leadId = Integer.parseInt(id);
        if (leadId < 0){
            throw new NumberFormatException();
        }
        Lead lead = leadList.get(leadId);
        if (lead == null){
            throw new NullPointerException();
        }
        System.out.println(lead);

    }

    public static void lookupOpportunity (String id, HashMap < Integer, Opportunity > opportunityList){
        Integer opportunityId = Integer.parseInt(id);
        if (opportunityId < 0){
            throw new NumberFormatException();
        }
        Opportunity opportunity = opportunityList.get(opportunityId);
        if (opportunity == null){
            throw new NullPointerException();
        }
        System.out.println(opportunity);
    }

    public static void closeLost (String id, HashMap < Integer, Opportunity > opportunityList){
        Integer opportunityId = Integer.parseInt(id);
        if (opportunityId < 0){
            throw new NumberFormatException();
        }
        Opportunity opportunity = opportunityList.get(opportunityId);
        if (opportunity == null){
            throw new NullPointerException();
        }
        opportunity.setStatus(Status.CLOSED_LOST);
    }

    public static void closeWon (String id, HashMap < Integer, Opportunity > opportunityList){
        Integer opportunityId = Integer.parseInt(id);
        if (opportunityId < 0){
            throw new NumberFormatException();
        }
        Opportunity opportunity = opportunityList.get(opportunityId);
        if (opportunity == null){
            throw new NullPointerException();
        }
        opportunity.setStatus(Status.CLOSED_WON);
    }

//    necesitamos este?
    public static void exit () {
    }

}