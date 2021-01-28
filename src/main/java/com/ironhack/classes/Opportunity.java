package com.ironhack.classes;

import com.ironhack.enums.*;

import java.util.*;

public class Opportunity {
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;
    //This allows us to generate ids that don't repeat
    private int opportunityId;
    private static int opportunityIdCounter = 0;

    public Opportunity(Product product,
                       int quantity,
                       Contact decisionMaker) {
        this.quantity = quantity;
        this.opportunityId = opportunityIdCounter++;
        this.product = product;
        this.decisionMaker = decisionMaker;
        this.status = Status.OPEN;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public int getOpportunityId() {
        return opportunityId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Opportunity " + opportunityId+
                "\nproduct = " + product +
                "\namount = " + quantity +
                ", \nstatus = " + status +
                ", \n" + decisionMaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return quantity == that.quantity &&
               product == that.product &&
               Objects.equals(decisionMaker, that.decisionMaker) &&
               status == that.status;
    }
}
