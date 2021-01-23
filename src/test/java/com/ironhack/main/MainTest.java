package com.ironhack.main;

import com.ironhack.classes.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    HashMap<Integer, Lead> leadList=new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    @Test
    void createNewLead_validParametersAndLeadList_Lead() {
        Main.createNewLead("Ana Campos",  647321563,"ana@email.com", "Transportes Campos S.L.", leadList);
        Lead test = new Lead("Ana Campos", 647321563,"ana@email.com", "Transportes Campos S.L.");
        assertEquals(test, leadList.get(0));
    }

//    @Test
//    void createNewLead_wrongParameters_IllegalArgumentException() {
//
//        assertThrows(IllegalArgumentException.class, () -> {Main.createNewLead("Ana Camp5os",  647321563,"ana@email.com", "Transportes Campos S.L.", leadList);});
//    }

    @Test
    void checkName() {
        assertEquals(false, Main.checkName("Ana Camp5os"));
    }
}