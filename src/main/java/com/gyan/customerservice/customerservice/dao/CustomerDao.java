package com.gyan.customerservice.customerservice.dao;

import com.gyan.customerservice.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,String> {
}
