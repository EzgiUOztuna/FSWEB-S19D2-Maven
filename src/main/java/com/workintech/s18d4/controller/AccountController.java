package com.workintech.s18d4.controller;

import com.workintech.s18d4.dao.AccountDao;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountDao accountDao;

    @Autowired
    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @GetMapping
    public List<Account> findAll(){
        return accountDao.getAllAccount();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable long id){
        return accountDao.getById(id);
    }

    @PostMapping("/{customerId}")
    public Account save(@PathVariable long customerId, @RequestBody Account account){
        Account savedAccount = accountDao.saveAccountForCustomer(customerId, account);
        return savedAccount;
    }

    @PutMapping("/{customerId}")
    public Account update(@PathVariable long customerId, @RequestBody Account account){
        Account updatedAccount = accountDao.updateAccountForCustomer(customerId, account);
        return updatedAccount;
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable long id){
        Account deletedAccount = accountDao.delete(id);
        return deletedAccount;
    }
}
