package com.workintech.s18d4.dao;
import com.workintech.s18d4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Long> {
//    List<Customer> getAllCustomer();
//    Customer getById(Long id);
//    Customer save(Customer customer);
//    Customer updateByID(Long id);
//    Customer delete(Long id);
}
