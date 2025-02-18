package com.workintech.s18d4.dao;
import com.workintech.s18d4.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{
    private EntityManager entityManager;

    @Autowired
    public CustomerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> getAllCustomer() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Transactional
    @Override
    public Customer updateByID(Long id) {
        Customer customer = getById(id);
        if(customer != null){
            entityManager.merge(customer);
        }
        return customer;
    }

    @Transactional
    @Override
    public Customer delete(Long id) {
        Customer customer = getById(id);
        entityManager.remove(customer);
        return customer;
    }
}
