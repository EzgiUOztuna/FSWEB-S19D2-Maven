package com.workintech.s18d4.dao;
import com.workintech.s18d4.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomer();
    Customer getById(Long id);
    Customer save(Customer customer);
    Customer updateByID(Long id);
    Customer delete(Long id);
}
