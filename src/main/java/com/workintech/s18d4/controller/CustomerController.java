package com.workintech.s18d4.controller;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAll(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable long id){
        return customerService.getById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        Customer savedCustomer = customerService.save(customer);
        return savedCustomer;
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable long id, @RequestBody Customer updatedCustomer){
        return customerService.updateByID(id,updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable long id) {
        Customer deletedCustomer = customerService.delete(id);
        return deletedCustomer;
    }
}
