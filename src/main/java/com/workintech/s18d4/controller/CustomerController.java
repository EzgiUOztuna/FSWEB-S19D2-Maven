package com.workintech.s18d4.controller;

import com.workintech.s18d4.dao.CustomerDao;
import com.workintech.s18d4.entity.Customer;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping
    public List<Customer> findAll(){
        return customerDao.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable long id){
        return customerDao.getById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        Customer savedCustomer = customerDao.save(customer);
        return savedCustomer;
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable long id){
        Customer updatedCustomer = customerDao.updateByID(id);
        return updatedCustomer;
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable long id) {
        Customer deletedCustomer = customerDao.delete(id);
        return deletedCustomer;
    }
}
