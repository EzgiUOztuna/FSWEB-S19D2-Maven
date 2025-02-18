package com.workintech.s18d4.service;
import com.workintech.s18d4.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer getById(Long id);
    Customer save(Customer customer);
    Customer updateByID(Long id, Customer updatedCustomer);
    Customer delete(Long id);
}
