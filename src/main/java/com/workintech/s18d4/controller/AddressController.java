package com.workintech.s18d4.controller;

import com.workintech.s18d4.dao.AddressDao;
import com.workintech.s18d4.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressDao addressDao;

    @Autowired
    public AddressController(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @GetMapping
    public List<Address> findAll(){
        return addressDao.getAllAddress();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable long id){
        return  addressDao.getById(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address){
        Address savedAddress = addressDao.save(address);
        return savedAddress;
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable long id){
        Address updatedAddress = addressDao.updateById(id);
        return updatedAddress;
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable long id){
        Address deletedAdress = addressDao.delete(id);
        return deletedAdress;
    }
}
