package com.ecommerce.EcommerceApi.controller;

import com.ecommerce.EcommerceApi.model.Address;
import com.ecommerce.EcommerceApi.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addresses")
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping("/addresses/{id}")
    public Address getAddressById(@PathVariable(value = "id") Integer addressId) {
        return addressService.getAddressById(addressId);
    }



    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PutMapping("/addresses/{id}")
    public Address updateAddress(@PathVariable(value = "id") Integer addressId, @Valid @RequestBody Address addressDetails) {
        return addressService.updateAddress(addressId, addressDetails);
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable(value = "id") Integer addressId) {
        addressService.deleteAddress(addressId);
    }
}

