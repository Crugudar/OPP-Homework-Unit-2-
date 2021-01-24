package com.ironhack.classes;

import com.ironhack.enums.*;

public class Opportunity {
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;
    private int opportunityId;
    private static int opportunityIdCounter = 0;

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
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
        return "Opportunity{" +
                "product=" + product +
                ", amount=" + quantity +
                ", decisionMaker=" + decisionMaker +
                ", status=" + status +
                ", opportunityId=" + opportunityId +
                '}';
    }
}
