package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.enums.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void newLead_validLead_lead() {
        Lead test = new Lead("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.");

        HashMap<Integer, Lead> leadList=new HashMap<>();
//        This id will be 1:
//        Command.newLead(new Lead("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L."), leadList);

        assertEquals(test, leadList.get(1));
    }

    @Test
    void newLead_invalidLead_lead() {
        Lead test = new Lead("Carlos Boti4jo", "647321593","carlos@email.com", "Transportes Botijo S.L.");

        HashMap<Integer, Lead> leadList=new HashMap<>();
//        This id will be 1:
//        Command.newLead(new Lead("Carlos Boti4jo", "647321593","carlos@email.com", "Transportes Botijo S.L."), leadList);

        assertEquals(test, leadList.get(1));
//        No problem, because this will be managed by Checker
    }

    @Test
    void convertLead_validValues_Opportunity() {
//        For this test, don't forget to go to Help->Edit Custom VM options and add the line: -Deditable.java.test.console=true
        Lead test = new Lead("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.");
        Opportunity opTest = new Opportunity(Product.BOX, 2, new Contact("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L."));

        HashMap<Integer, Lead> leadList=new HashMap<>();
        leadList.put(test.getLeadId(), test);

        HashMap<Integer, Opportunity> opportunityList=new HashMap<>();

        assertTrue(leadList.isEmpty());
        assertEquals(opTest, opportunityList.get(1));
//        The exceptions of this method will be thrown by the methods askOpportunityInfo and askAccountInfo, so,
//        for simplicity, the checks for invalid values will be done in their tests
    }

    @Test
    void lookupLead() {
    }

    @Test
    void lookupOpportunity() {
    }

    @Test
    void closeLost() {
    }

    @Test
    void closeWon() {
    }
}