package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
@Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer find(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(long id) {
        Customer customer = find(id);
        customerRepository.delete(customer);
        return customer;
    }


/*
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerDao) {
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

    }*/
}
