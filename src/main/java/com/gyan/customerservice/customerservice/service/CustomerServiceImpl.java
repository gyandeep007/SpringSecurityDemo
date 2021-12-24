package com.gyan.customerservice.customerservice.service;

import com.gyan.customerservice.customerservice.dao.CustomerDao;
import com.gyan.customerservice.customerservice.entity.Customer;
import com.gyan.customerservice.customerservice.exception.CustomerNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer findCustomerById(String id) {
      Optional<Customer> customer = customerDao.findById(id);
      if(!customer.isPresent()){
          throw new CustomerNotFound("Customer with id "+id+" doesn't exist");
      }
      return customer.get();
    }

    @Override
    public List<Customer> findAllCustomer() {
       return customerDao.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
            return customerDao.save(customer);

    }

    @Override
    public String deleteCustomer(String id) {
         customerDao.deleteById(id);
         return id;
    }

    @Override
    public List<Customer> processCustomers(List<Customer> customers) {
       List<Customer> errorList = new ArrayList<>();
       for (Customer customer:customers){
           try {
               customerDao.save(customer);
           }catch (Exception e){
               errorList.add(customer);
           }
       }
       return errorList.size()>0?errorList:customers;
    }

    @Override
     public List<Customer> findCustomerByIds(List<String> ids) {
         List<Customer> customers = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        for (String id:ids){
            try {
               customers.add( customerDao.findById(id).get());
            }catch (Exception e){
                errors.add(id);
            }
        }
        System.out.println("errors :"+errors);
        return customers;

    }
}
