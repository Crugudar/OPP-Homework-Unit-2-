package com.ironhack.utils;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.ironhack.utils.ScanInfo.*;
import static org.junit.jupiter.api.Assertions.*;

class ScanInfoTest {

    @Test
    void test_askName_validName() {
        String name = "Pepa Pig";
        InputStream in = new ByteArrayInputStream(name.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(name, askName());
        System.setIn(inBackUp);
    }

    @Test
    void test_askPhone_validPhone() {
        String phone = "635698745";
        InputStream in = new ByteArrayInputStream(phone.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(phone, askPhone());
        System.setIn(inBackUp);
    }

    @Test
    void test_askEmail_validEmail() {
        String email = "uwu@uwu.es";
        InputStream in = new ByteArrayInputStream(email.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(email, askEmail());
        System.setIn(inBackUp);
    }

    @Test
    void test_askProduct_validProduct() {
        String product = "BOX";
        InputStream in = new ByteArrayInputStream(product.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(Product.BOX, askProduct());
        System.setIn(inBackUp);
    }

    @Test
    void test_askquantity_validProduct() {
        String quantity = "1";
        Integer num;
        num = Integer.parseInt(quantity);
        InputStream in = new ByteArrayInputStream(quantity.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(num, askQuantity());
        System.setIn(inBackUp);
    }

    @Test
    void test_askIndustry_validIndustry() {
        String industry = "PRODUCE";
        InputStream in = new ByteArrayInputStream(industry.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(Industry.PRODUCE, askIndustry());
        System.setIn(inBackUp);
    }

    @Test
    void test_askEmployees_validEmployees() {
        String employees = "1";
        Integer num;
        num = Integer.parseInt(employees);
        InputStream in = new ByteArrayInputStream(employees.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(num, askEmployees());
        System.setIn(inBackUp);
    }

    @Test
    void test_askCity_validCity() {
        String city = "Madrid";
        InputStream in = new ByteArrayInputStream(city.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(city, askCity());
        System.setIn(inBackUp);
    }

    @Test
    void test_askCountry_validCountry() {
        String country = "España";
        InputStream in = new ByteArrayInputStream(country.getBytes());
        InputStream inBackUp = System.in;
        System.setIn(in);
        assertEquals(country, askCountry());
        System.setIn(inBackUp);
    }





}