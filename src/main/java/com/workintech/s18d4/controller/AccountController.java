package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;
    private CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable long id){
        return accountService.find(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@PathVariable long customerId, @RequestBody Account account){
        Customer customer = customerService.find(customerId);
        if(customer != null){
            customer.getAccounts().add(account);
            account.setCustomer(customer);
            accountService.save(account);
        } else {
            throw new RuntimeException("no customer found");
        }
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(), new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@PathVariable long customerId, @RequestBody Account account){
       Customer customer = customerService.find(customerId);
       Account toBeUpdatedAccount = null;

       for(Account account1 : customer.getAccounts()){
           if(account.getId() == account1.getId()){
               toBeUpdatedAccount = account1;
           }
        }
       if(toBeUpdatedAccount == null){
           throw new RuntimeException("Account(" + account.getId()+ ") not found for this customer: " + customerId);
       }
       int indexOfToBeUpdated = customer.getAccounts().indexOf(toBeUpdatedAccount);
       customer.getAccounts().set(indexOfToBeUpdated, account);
       account.setCustomer(customer);
       accountService.save(account);
       return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
               new CustomerResponse(customerId, customer.getEmail(), customer.getSalary()));
    }

    @DeleteMapping("/{id}")
    public AccountResponse remove(@PathVariable long id){
        Account account = accountService.delete(id);
        if(account == null){
            throw new RuntimeException("no account found");
        }
        accountService.delete(id);
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(account.getId(), account.getCustomer().getEmail(), account.getCustomer().getSalary()));
    }
}
