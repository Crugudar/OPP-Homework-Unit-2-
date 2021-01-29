package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.enums.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    Lead testValid;
    Lead testInvalid;
    HashMap<Integer, Lead> leadListTest;
    Contact contactValidTest;
    Contact contactInvalidTest;
    HashMap<Integer, Opportunity> opportunityListTest;
    Opportunity opportunityValidTest;
    Opportunity opportunityInvalidTest;
    Account validAccount;
    Account invalidAccount;

    @BeforeEach
    void setUp() {
        testValid = new Lead("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.");
        testInvalid = new Lead("Carlos Boti4jo", "647321593","carlos@email.com", "Transportes Botijo S.L.");
        leadListTest=new HashMap<>();

        contactValidTest = new Contact("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.");
        contactInvalidTest = new Contact("Carlos Boti4jo", "647321593","carlos@email.com", "Transportes Botijo S.L.");

        opportunityValidTest = new Opportunity(Product.BOX, 2, contactValidTest);
        opportunityInvalidTest = new Opportunity(Product.BOX, 2, contactInvalidTest);
        opportunityListTest = new HashMap<>();

        validAccount = new Account(Industry.ECOMMERCE, 2, "Narnia", "Narnia", contactValidTest, opportunityValidTest);
        invalidAccount = new Account(Industry.ECOMMERCE, 2, "Narnia", "Narnia", contactInvalidTest, opportunityInvalidTest);
    }

    @AfterEach
    void tearDown() {
        leadListTest.clear();
    }

    @Test
    void newLead_validLead_lead() {
        Command.newLead("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.", leadListTest);

        assertEquals(testValid, leadListTest.get(leadListTest.keySet().toArray()[0]));
    }

    @Test
    void newLead_invalidLead_lead() {
        Command.newLead("Carlos Boti4jo", "647321593","carlos@email.com", "Transportes Botijo S.L.", leadListTest);

        assertEquals(testInvalid, leadListTest.get(leadListTest.keySet().toArray()[0]));
//        No problem, because this will be managed by Checker
    }

    @Test
    void createContact_validLead_contact() {
        assertEquals(contactValidTest, Command.createContact(testValid));
    }

    @Test
    void createContact_invalidLead_contact() {
        assertEquals(contactInvalidTest, Command.createContact(testInvalid));
    }

    @Test
    void createOpportunity_validValues_Opportunity() {
        assertEquals(opportunityValidTest, Command.createOpportunity(Product.BOX, 2, new Contact("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L."), opportunityListTest));
    }

    @Test
    void createOpportunity_invalidValues_Opportunity() {
        assertEquals(opportunityInvalidTest, Command.createOpportunity(Product.BOX, 2, new Contact("Carlos Boti4jo", "647321593","carlos@email.com", "Transportes Botijo S.L."), opportunityListTest));
    }

    @Test
    void createAccount_validValues_Account() {
        assertEquals(validAccount, Command.createAccount(Industry.ECOMMERCE, 2, "Narnia", "Narnia",
                new Contact("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L."),
                new Opportunity(Product.BOX, 2, contactValidTest)));
    }

    @Test
    void createAccount_invalidValues_Account() {
        assertEquals(invalidAccount, Command.createAccount(Industry.ECOMMERCE, 2, "Narnia", "Narnia",
                new Contact("Carlos Boti4jo", "647321593","carlos@email.com", "Transportes Botijo S.L."),
                new Opportunity(Product.BOX, 2, contactInvalidTest)));
    }

    @Test
    void removeLead_validValues_map() {
        leadListTest.put(testValid.getLeadId(), testValid);
        Command.removeLead(testValid.getLeadId(), leadListTest);
        assertTrue(leadListTest.isEmpty());
    }

    @Test
    void removeLead_invalidValues_map() {
        leadListTest.put(testValid.getLeadId(), testValid);
        Command.removeLead(7, leadListTest);
//        Nothing happens, the value in index 7 is just null
        assertTrue(leadListTest.size() == 1);
    }

    @Test
    void closeLost_validValues_Opportunity() {
        opportunityValidTest.setStatus(Status.CLOSED_LOST);
        opportunityListTest.put(1, new Opportunity(Product.BOX, 2, new Contact("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.")));
        Command.closeLost("1", opportunityListTest);
        assertEquals(opportunityValidTest, opportunityListTest.get(1));
    }

    @Test
    void closeLost_invalidValues_Opportunity() {
        opportunityListTest.put(1, new Opportunity(Product.BOX, 2, new Contact("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.")));
        assertThrows(NullPointerException.class, () -> {Command.closeLost("0", opportunityListTest);});
    }

    @Test
    void closeWon_validValues_Opportunity() {
        opportunityValidTest.setStatus(Status.CLOSED_WON);
        opportunityListTest.put(1, new Opportunity(Product.BOX, 2, new Contact("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.")));
        Command.closeWon("1", opportunityListTest);
        assertEquals(opportunityValidTest, opportunityListTest.get(1));
    }


    @Test
    void closeWon_invalidValues_Opportunity() {
        opportunityListTest.put(1, new Opportunity(Product.BOX, 2, new Contact("Carlos Botijo", "647321593","carlos@email.com", "Transportes Botijo S.L.")));
        assertThrows(NullPointerException.class, () -> {Command.closeLost("0", opportunityListTest);});
    }

    @Test
    void lookupLead_invalidValues_NumberFormatException() {
        assertThrows(NumberFormatException.class, () -> Command.lookupLead("-1", leadListTest));
    }

    @Test
    void lookupLead_nullId_NullPointerException() {
        assertThrows(NumberFormatException.class, () -> Command.lookupLead(null, leadListTest));
    }

    @Test
    void lookupLead_nullLead_NullPointerException() {
        assertThrows(NullPointerException.class, () -> Command.lookupLead("345", leadListTest));
    }

    @Test
    void lookupOpportunity_invalidValues_NumberFormatException() {
        assertThrows(NumberFormatException.class, () -> Command.lookupOpportunity("-1", opportunityListTest));
    }

    @Test
    void lookupOpportunity_nullId_NullPointerException() {
        assertThrows(NumberFormatException.class, () -> Command.lookupOpportunity(null, opportunityListTest));
    }

    @Test
    void lookupOpportunity_nullLead_NullPointerException() {
        assertThrows(NullPointerException.class, () -> Command.lookupOpportunity("345", opportunityListTest));
    }
}