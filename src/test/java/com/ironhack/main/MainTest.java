package com.ironhack.main;

import com.ironhack.classes.Lead;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    HashMap<Integer, Lead> leadList=new HashMap<>();
    Scanner scanner = new Scanner(System.in);


    @Test
    public void checkname_validname_name(){
        assertEquals(true, Main.checkName("Pepa Pig"));
    }

    @Test
    public void checkname_errorname_error(){
        assertThrows(IllegalArgumentException.class, ()-> Main.checkName("Pepa"));
    }

    @Test
    public void checkphone_validphone_phone(){
        assertEquals(true, Main.checkPhone("900876543"));
    }

    @Test
    public void checkphone_errorphone_error(){
        assertThrows(IllegalArgumentException.class, ()-> Main.checkPhone("767"));
    }

    @Test
    public void checkemail_validemail_email(){
        assertEquals(true, Main.checkEmail("uwu@uwu.es"));
    }

    @Test
    public void checkemail_erroremail_error(){
        assertThrows(IllegalArgumentException.class, ()-> Main.checkEmail("Pepa"));
    }

    @Test
    public void checkCompany_validCompany_company(){
        assertEquals(true, Main.checkCompName("UWU S.A."));
    }

    @Test
    public void checkCompany_errorCompany_error(){
        assertThrows(IllegalArgumentException.class, ()-> Main.checkCompName(""));
    }

}