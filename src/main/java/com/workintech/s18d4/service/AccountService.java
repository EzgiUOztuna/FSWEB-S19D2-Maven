package com.workintech.s18d4.service;
import com.workintech.s18d4.entity.Account;
import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account find(long id);
    Account save(Account account);
    //Account saveAccountForCustomer(Long customerId, Account account);
    //Account updateAccountForCustomer(Long customerId, Account account);
    Account delete(long id);
}
