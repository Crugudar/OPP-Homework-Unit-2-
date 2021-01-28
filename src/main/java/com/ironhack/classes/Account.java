package com.ironhack.classes;

import com.ironhack.enums.Industry;

import java.util.*;

public class Account {
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList = new ArrayList<>();
    private List<Opportunity> opportunityList = new ArrayList<>();
    //This allows us to generate ids that don't repeat
    private final int accountId;
    private static int accountIdCounter = 0;

    public Account(Industry industry,
                   int employeeCount,
                   String city,
                   String country,
                   Contact contact,
                   Opportunity opportunity) {
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.industry = industry;
        this.contactList.add(contact);
        this.opportunityList.add(opportunity);
        this.accountId = accountIdCounter++;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "industry=" + industry +
                ", employeeCount=" + employeeCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                ", accountId=" + accountId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return employeeCount == account.employeeCount && industry == account.industry && Objects.equals(city, account.city) && Objects.equals(country, account.country) && Objects.equals(contactList, account.contactList) && Objects.equals(opportunityList, account.opportunityList);
    }
}
