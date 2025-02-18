package com.workintech.s18d4.dao;
import com.workintech.s18d4.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressDao extends JpaRepository<Address, Long> {

//    List<Address> getAllAddress();
//    Address getById(Long id);
//    Address save(Address address);
//    Address updateById(Long id);
//    Address delete(Long id);
}
