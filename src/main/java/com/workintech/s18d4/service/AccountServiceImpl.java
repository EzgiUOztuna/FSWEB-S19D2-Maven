package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.AccountDao;
import com.workintech.s18d4.dao.CustomerDao;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;
    private CustomerDao customerDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> getAllAccount() {
        return accountDao.findAll();
    }

    @Override
    public Account getById(Long id) {
        Optional<Account> optionalAccount = accountDao.findById(id);
        return optionalAccount.orElse(null);
    }

    @Transactional
    @Override
    public Account saveAccountForCustomer(Long customerId, Account account) {
        Customer customer = customerDao.findById(customerId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer with ID " + customerId + " not found!");
        }
        // Account'u müşteriyle ilişkilendir.
        account.setCustomer(customer);
        return accountDao.save(account);
    }

    @Transactional
    @Override
    public Account updateAccountForCustomer(Long customerId, Account account) {
        // 1️⃣ Müşteriyi bul
        Customer customer = customerDao.findById(customerId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer with ID " + customerId + " not found!");
        }

        // 2️⃣ Account güncelleme
        Account updatedAccount = accountDao.findById(account.getId()).orElse(null);
        if (updatedAccount == null) {
            throw new RuntimeException("Account with ID " + account.getId() + " not found!");
        }

        // 3️⃣ Yeni bilgileri mevcut hesaba aktar
        updatedAccount.setAccountName(account.getAccountName());
        updatedAccount.setMoneyAmount(account.getMoneyAmount());
        updatedAccount.setCustomer(account.getCustomer());

        return accountDao.save(updatedAccount);

    }

    @Transactional
    @Override
    public Account delete(Long id) {
        Optional<Account> optionalAccount = accountDao.findById(id);
        if(optionalAccount.isPresent()){
            accountDao.deleteById(id);
            return optionalAccount.get();
        } else {
            throw new RuntimeException("Account with ID " + id + " not found.");
        }
    }


//    private EntityManager entityManager;
//
//    @Autowired
//    public AccountDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Account> getAllAccount() {
//        TypedQuery<Account>query = entityManager.createQuery("SELECT t FROM Account t", Account.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Account getById(Long id) {
//        return entityManager.find(Account.class, id);
//    }
//
//    @Transactional
//    @Override
//    public Account saveAccountForCustomer(Long customerId, Account account) {
//        Customer customer = entityManager.find(Customer.class, customerId);
//        if(customer == null){
//            throw new RuntimeException("Customer not found");
//        }
//        // Account'u müşteriyle ilişkilendir.
//        account.setCustomer(customer);
//
//        // Account'u veritabanına kaydet.
//        entityManager.persist(account);
//        return account;
//    }
//
//    @Transactional
//    @Override
//    public Account updateAccountForCustomer(Long customerId, Account account) {
//        // customerId ile ilişkili Customer'ı buluyoruz
//        Customer customer = entityManager.find(Customer.class, customerId);
//        if(customer == null){
//            throw new RuntimeException("Customer not found");
//        }
//        // Account'u müşteriyle ilişkilendiriyoruz
//        account.setCustomer(customer);
//
//        // Yeni bilgileriyle Account objesini güncelliyoruz
//        Account newAccount = entityManager.find(Account.class, account.getId());
//        if(newAccount != null){
//            newAccount.setMoneyAmount(account.getMoneyAmount());
//            entityManager.merge(newAccount);
//        } else {
//            throw new RuntimeException("Account not found");
//        }
//        return newAccount;
//    }
//
//    @Transactional
//    @Override
//    public Account delete(Long id) {
//        Account account = getById(id);
//        entityManager.remove(account);
//        return account;
//    }
}
