package com.ironhack.utils;

import com.ironhack.classes.*;
import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
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

    @Test
    public void checkProduct_validProduct_product(){
        assertEquals(Product.HYBRID, Checker.checkProduct("hybrid"));
        assertEquals(Product.FLATBED, Checker.checkProduct("flatbed"));
        assertEquals(Product.BOX, Checker.checkProduct("BOX"));
    }

    @Test
    public void checkProduct_errorProduct_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkProduct("carpeta"));
    }

    @Test
    public void checkQuantity_validQuantity_quantity(){
        assertEquals(true, Checker.checkQuantity(5));
    }

    @Test
    public void checkQuantity_validQuantity_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkQuantity(0));
    }

    @Test
    public void checkIndustry_validIndustry_industry(){
        assertEquals(Industry.PRODUCE, Checker.checkIndustry("PRODUCE"));
        assertEquals(Industry.ECOMMERCE, Checker.checkIndustry("ECOMMERCE"));
        assertEquals(Industry.MANUFACTURING, Checker.checkIndustry("MANUFACTURING"));
        assertEquals(Industry.MEDICAL, Checker.checkIndustry("medical"));
        assertEquals(Industry.OTHER, Checker.checkIndustry("OTHER"));
    }

    @Test
    public void checkIndustry_errorIndustry_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkProduct("Mariscos Recio"));
    }

    @Test
    public void checkEmployees_validEmployees_employees(){
        assertEquals(true, Checker.checkEmployees(500));
    }

    @Test
    public void checkEmployees_validEmployees_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkEmployees(0));
    }

    @Test
    public void checkCity_validCity_city(){
        assertEquals(true, Checker.checkCity("Madrid"));
    }

    @Test
    public void checkCity_validCity_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkCity(""));
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkCity("M4dr1d"));
    }

    @Test
    public void checkCountry_validCountry_Country(){
        assertEquals(true, Checker.checkCity("España"));
    }

    @Test
    public void checkCountry_validCountry_error(){
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkCity(""));
        assertThrows(IllegalArgumentException.class, ()-> Checker.checkCity("3sp4ñ4"));
    }








}