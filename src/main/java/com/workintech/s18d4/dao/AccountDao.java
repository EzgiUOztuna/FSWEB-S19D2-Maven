package com.workintech.s18d4.dao;
import com.workintech.s18d4.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDao extends JpaRepository<Account, Long> {

}
