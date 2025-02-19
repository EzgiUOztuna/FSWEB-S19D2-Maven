package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> findAll(){
        return addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable long id){
        return  addressService.getById(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address){
        Address savedAddress = addressService.save(address);
        return savedAddress;
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable long id , @RequestBody Address updatedAddress){
        return addressService.updateById(id,updatedAddress);
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable long id){
        Address deletedAdress = addressService.delete(id);
        return deletedAdress;
    }
}
*/