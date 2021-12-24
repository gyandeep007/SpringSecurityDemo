package com.gyan.customerservice.customerservice.service;

import com.gyan.customerservice.customerservice.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CustomerService {
    Customer findCustomerById(String id);
    List<Customer> findAllCustomer();
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    String deleteCustomer(String id);
    List<Customer> processCustomers(List<Customer> customers);
    List<Customer> findCustomerByIds(List<String> ids);
}
