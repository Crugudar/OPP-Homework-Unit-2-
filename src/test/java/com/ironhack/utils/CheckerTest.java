package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.main.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

//    SI NO SE USA POS SE BORRA UWU
//    HashMap<Integer, Lead> leadList=new HashMap<>();
//    Scanner scanner = new Scanner(System.in);

    @Test
    public void checkname_validname_name(){
        assertEquals(true, Checker.checkName("Pepa Pig"));
    }

    @Test
    public void checkname_errorname_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkName("Pepa"));
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkName("Pepa Pig14"));
    }

    @Test
    public void checkphone_validphone_phone(){
        assertEquals(true, Checker.checkPhone("900876543"));
    }

    @Test
    public void checkphone_errorphone_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkPhone("767"));
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkPhone("500876543"));
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkPhone("50087654398"));
    }

    @Test
    public void checkemail_validemail_email(){
        assertEquals(true, Checker.checkEmail("uwu@uwu.es"));
    }

    @Test
    public void checkemail_erroremail_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkEmail("Pepa"));
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkEmail("Pepa@ajoij@.com"));
    }

    @Test
    public void checkCompany_validCompany_company(){
        assertEquals(true, Checker.checkCompName("UWU S.A."));
    }

    @Test
    public void checkCompany_errorCompany_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkCompName(""));
    }
}