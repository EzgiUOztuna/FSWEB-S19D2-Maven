package com.workintech.s18d4.service;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.AddressRepository;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address find(long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address delete(long id) {
        Address address = find(id);
        addressRepository.delete(address);
        return address;
    }
/*
    @Autowired
    public AddressServiceImpl(AddressRepository addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> getAllAddress() {
       return addressDao.findAll();
    }

    @Override
    public Address getById(Long id) {
        Optional<Address> optionalAddress = addressDao.findById(id);
        return optionalAddress.orElse(null);
    }

    @Transactional
    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }

    @Transactional
    @Override
    public Address updateById(Long id, Address updatedAddress) {
        Optional<Address> optionalAddress = addressDao.findById(id);

        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();

            // Güncelleme işlemi
            existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setNo(updatedAddress.getNo());
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setCountry(updatedAddress.getCountry());
            existingAddress.setDescription(updatedAddress.getDescription());

            return addressDao.save(existingAddress); // save() hem insert hem update yapar.
        } else {
            throw new RuntimeException("Address with ID " + id + " not found.");
        }
    }

    @Transactional
    @Override
    public Address delete(Long id) {
        Optional<Address> optionalAddress = addressDao.findById(id);
        if(optionalAddress.isPresent()){
            addressDao.deleteById(id);
            return optionalAddress.get();
        } else {
            throw new RuntimeException("Address with ID " + id + " not found.");
        }

    }*/
}
