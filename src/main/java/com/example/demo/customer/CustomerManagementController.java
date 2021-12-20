package com.example.demo.customer;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/customers")
public class CustomerManagementController {

    private static final List<Customer> CUSTOMERS = Arrays.asList(
            new Customer(1, "Gulcin Ozkahya"),
            new Customer(2, "Berk Saltuk Yilmaz")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public List<Customer> getAllCustomers(){
        return CUSTOMERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('customer:write')")
    public void registerNewCustomer(@RequestBody Customer c)
    {
        System.out.println(c);
    }

    @DeleteMapping(path = "{customerId}")
    @PreAuthorize("hasAuthority('customer:write')")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId)
    {
        System.out.println(customerId);
    }

    @PutMapping(path = "{customerId}")
    @PreAuthorize("hasAuthority('customer:write')")
    public void updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer c)
    {
        System.out.println(String.format("%s %s", customerId, c));
    }
}