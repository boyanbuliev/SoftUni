package com.example.demo.services;

import com.example.demo.entities.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Long id);

    Address addAddress(Address address);

    Address updateAddress(Address address);

    Address deleteAddress(Long id);

    long getAddressCount();
}
