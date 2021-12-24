package com.gyan.customerservice.customerservice.controller;


import com.gyan.customerservice.customerservice.entity.Customer;
import com.gyan.customerservice.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/customer/{id}")
    public Customer findCustomerById( @PathVariable String id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping(value = "/customers")
    public List<Customer> findAllCustomer() {
        return customerService.findAllCustomer();
    }
    @PostMapping(value = "/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PostMapping(value = "/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return id;
    }

    @PostMapping(value = "/processCustomer")
    public List<Customer> processCustomer(@RequestBody List<Customer> customers) {
        return customerService.processCustomers(customers);
    }

    @GetMapping(value = "/customerByIds")
    public List<Customer> findAllCustomerByIds(@RequestBody List<String> ids) {
        return customerService.findCustomerByIds(ids);
    }

}
