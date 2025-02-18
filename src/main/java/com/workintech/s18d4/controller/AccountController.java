package com.workintech.s18d4.controller;

import com.workintech.s18d4.dao.AccountDao;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> findAll(){
        return accountService.getAllAccount();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable long id){
        return accountService.getById(id);
    }

    @PostMapping("/{customerId}")
    public Account save(@PathVariable long customerId, @RequestBody Account account){
        Account savedAccount = accountService.saveAccountForCustomer(customerId, account);
        return savedAccount;
    }

    @PutMapping("/{customerId}")
    public Account update(@PathVariable long customerId, @RequestBody Account account){
        return accountService.updateAccountForCustomer(customerId, account);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable long id){
        Account deletedAccount = accountService.delete(id);
        return deletedAccount;
    }
}
