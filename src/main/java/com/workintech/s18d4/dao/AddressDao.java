package com.workintech.s18d4.dao;

import com.workintech.s18d4.entity.Address;

import java.util.List;

public interface AddressDao {

    List<Address> getAllAddress();
    Address getById(Long id);
    Address save(Address address);
    Address updateById(Long id);
    Address delete(Long id);
}
