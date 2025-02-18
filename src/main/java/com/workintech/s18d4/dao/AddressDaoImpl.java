package com.workintech.s18d4.dao;
import com.workintech.s18d4.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AddressDaoImpl { // implements AddressDao
//    private EntityManager entityManager;
//
//    @Autowired
//    public AddressDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Address> getAllAddress() {
//        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a", Address.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Address getById(Long id) {
//        return entityManager.find(Address.class, id);
//    }
//
//    @Transactional
//    @Override
//    public Address save(Address address) {
//        entityManager.persist(address);
//        return address;
//    }
//
//    @Transactional
//    @Override
//    public Address updateById(Long id) {
//        Address address = getById(id);
//        if(address != null){
//            entityManager.merge(address);
//        }
//        return address;
//    }
//
//    @Transactional
//    @Override
//    public Address delete(Long id) {
//        Address address = getById(id);
//        entityManager.remove(address);
//        return address;
//    }
}
