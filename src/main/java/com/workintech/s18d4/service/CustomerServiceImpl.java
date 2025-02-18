package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.CustomerDao;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.findAll();
    }

    @Override
    public Customer getById(Long id) {
        Optional<Customer> optionalCustomer = customerDao.findById(id);
        return optionalCustomer.orElse(null);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    @Transactional
    @Override
    public Customer updateByID(Long id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerDao.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();

            // Güncelleme işlemi
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setSalary(updatedCustomer.getSalary());
            existingCustomer.setAddress(updatedCustomer.getAddress());

            return customerDao.save(existingCustomer); // save() hem insert hem update yapar.
        } else {
            throw new RuntimeException("Customer with ID " + id + " not found.");
        }
    }

    @Transactional
    @Override
    public Customer delete(Long id) {
        Optional<Customer> optionalCustomer = customerDao.findById(id);
        if(optionalCustomer.isPresent()){
            customerDao.deleteById(id);
            return optionalCustomer.get();
        } else {
            throw new RuntimeException("Customer with ID " + id + " not found.");
        }

    }
}
