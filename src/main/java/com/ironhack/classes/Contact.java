package com.ironhack.classes;

import java.util.*;

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    //This allows us to generate ids that don't repeat
    private final int contactId;
    private static int contactIdCounter = 0;

    public Contact(String name,
                   String phoneNumber,
                   String email,
                   String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.contactId = contactIdCounter++;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
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
        return "Contact: " +
                "\n  name = " + name +
                ", \n  phoneNumber = " + phoneNumber +
                ", \n  email = " + email  +
                ", \n  companyName = " + companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
               Objects.equals(phoneNumber, contact.phoneNumber) &&
               Objects.equals(email, contact.email) &&
               Objects.equals(companyName, contact.companyName);
    }
}
