package com.ecommerce.EcommerceApi.service;

import com.ecommerce.EcommerceApi.dao.IAddressRepository;
import com.ecommerce.EcommerceApi.dao.ResourceNotFoundException;
import com.ecommerce.EcommerceApi.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private IAddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(Integer addressId) {
        try {
            return addressRepository.findById(addressId)
                    .orElseThrow(() -> new ResourceNotFoundException("Address", "id"));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }



    public Address updateAddress(Integer addressId, Address addressDetails) {
        Address address = getAddressById(addressId);
        address.setAddressName(addressDetails.getAddressName());
        address.setLandmark(addressDetails.getLandmark());
        address.setPhoneNumber(addressDetails.getPhoneNumber());
        address.setZipCode(addressDetails.getZipCode());
        address.setState(addressDetails.getState());
        return addressRepository.save(address);
    }

    public void deleteAddress(Integer addressId) {
        Address address = getAddressById(addressId);
        addressRepository.delete(address);
    }
}

