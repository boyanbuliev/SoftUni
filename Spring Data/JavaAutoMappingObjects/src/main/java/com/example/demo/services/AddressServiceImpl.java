package com.example.demo.services;

import com.example.demo.entities.Address;
import com.example.demo.exception.NonexistentEntityException;
import com.example.demo.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
//        return addressRepository.getOne(id);
        return addressRepository.findById(id).orElseThrow(() -> new NonexistentEntityException(
                String.format("Address with id =%s does not exist", id)));
    }

    @Transactional
    @Override
    public Address addAddress(Address address) {
        address.setId(null);
        return addressRepository.save(address);
    }

    @Transactional
    @Override
    public Address updateAddress(Address address) {
        getAddressById(address.getId());
        return addressRepository.save(address);
    }

    @Transactional
    @Override
    public Address deleteAddress(Long id) {
        Address removed = addressRepository.getOne(id);
        addressRepository.delete(addressRepository.getOne(id));
        return removed;
    }

    @Override
    public long getAddressCount() {
        return addressRepository.count();
    }
}
