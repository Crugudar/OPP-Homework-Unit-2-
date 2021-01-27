package com.ironhack.classes;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Product;

import java.util.*;

public class Lead {
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private final int leadId;
    private static int leadIdCounter = 0;

    public Lead(String name,
                String phoneNumber,
                String email,
                String companyName) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.leadId = leadIdCounter++;
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

    public int getLeadId() {
        return leadId;
    }

    @Override
    public String toString() {
        return "Lead " + leadId +
                "\nname = " + name +
                ", \nphoneNumber = " + phoneNumber +
                ", \nemail = " + email +
                ", \ncompanyName = " + companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return phoneNumber == lead.phoneNumber &&
               Objects.equals(name, lead.name) &&
               Objects.equals(email, lead.email) &&
               Objects.equals(companyName, lead.companyName);
    }
}
