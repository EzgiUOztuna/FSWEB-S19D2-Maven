package com.workintech.s18d4.dao;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    private EntityManager entityManager;

    @Autowired
    public AccountDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> getAllAccount() {
        TypedQuery<Account>query = entityManager.createQuery("SELECT t FROM Account t", Account.class);
        return query.getResultList();
    }

    @Override
    public Account getById(Long id) {
        return entityManager.find(Account.class, id);
    }

    @Transactional
    @Override
    public Account saveAccountForCustomer(Long customerId, Account account) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if(customer == null){
            throw new RuntimeException("Customer not found");
        }
        // Account'u müşteriyle ilişkilendir.
        account.setCustomer(customer);

        // Account'u veritabanına kaydet.
        entityManager.persist(account);
        return account;
    }

    @Transactional
    @Override
    public Account updateAccountForCustomer(Long customerId, Account account) {
        // customerId ile ilişkili Customer'ı buluyoruz
        Customer customer = entityManager.find(Customer.class, customerId);
        if(customer == null){
            throw new RuntimeException("Customer not found");
        }
        // Account'u müşteriyle ilişkilendiriyoruz
        account.setCustomer(customer);

        // Yeni bilgileriyle Account objesini güncelliyoruz
        Account newAccount = entityManager.find(Account.class, account.getId());
        if(newAccount != null){
            newAccount.setMoneyAmount(account.getMoneyAmount());
            entityManager.merge(newAccount);
        } else {
            throw new RuntimeException("Account not found");
        }
        return newAccount;
    }

    @Transactional
    @Override
    public Account delete(Long id) {
        Account account = getById(id);
        entityManager.remove(account);
        return account;
    }
}
