package com.workintech.s18d4.service;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.entity.Customer;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address find(long id);
    Address save(Address address);
    Address delete(long id);
}
