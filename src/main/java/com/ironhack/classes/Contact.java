package com.ironhack.classes;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String name;
    private int phoneNumber;
    private String email;
    private String companyName;
    private final int contactId;
    private static int contactIdCounter = 0;

    public Contact(String name, int phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.contactId = contactIdCounter++;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getContactId() {
        return contactId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", contactId=" + contactId +
                '}';
    }


}
