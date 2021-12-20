package com.example.demo.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private static final List<Customer> CUSTOMERS = Arrays.asList(
      new Customer(1, "Gulcin Ozkahya"),
      new Customer(2, "Berk Saltuk Yilmaz")
    );

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId){
        return CUSTOMERS.stream()
                .filter(student -> customerId.equals(student.getCustomerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Customer " + customerId + " does not exist"));
    }
}
