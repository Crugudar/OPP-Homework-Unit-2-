package com.ironhack.classes;

import com.ironhack.enums.*;

public class Opportunity {
    private Product product;
    private int amount;
    private Contact decisionMaker;
    private Status status;
    private int opportunityId;
    private static int opportunityIdCounter = 0;

    public Opportunity(Product product, int amount, Contact decisionMaker) {
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Opportunity{" +
                "product=" + product +
                ", amount=" + amount +
                ", decisionMaker=" + decisionMaker +
                ", status=" + status +
                ", opportunityId=" + opportunityId +
                '}';
    }
}
