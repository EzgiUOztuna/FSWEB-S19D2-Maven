package com.workintech.s18d4.service;
import com.workintech.s18d4.entity.Account;
import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    Account getById(Long id);
    Account saveAccountForCustomer(Long customerId, Account account);
    Account updateAccountForCustomer(Long customerId, Account account);
    Account delete(Long id);
}
