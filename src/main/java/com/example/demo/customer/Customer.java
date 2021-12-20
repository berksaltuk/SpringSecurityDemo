package com.example.demo.customer;

public class Customer {

    private final Integer customerId;
    private final String customerName;

    public Customer(Integer customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }
}
