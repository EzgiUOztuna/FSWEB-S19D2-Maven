package com.workintech.s18d4.dao;
import com.workintech.s18d4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
