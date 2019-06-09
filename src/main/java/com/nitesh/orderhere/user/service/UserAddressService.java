package com.nitesh.orderhere.user.service;

import com.nitesh.orderhere.user.model.Address;
import com.nitesh.orderhere.user.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

    @Autowired
    UserAddressRepository userAddressRepository;

    public void saveAddress(Address address){
        this.userAddressRepository.save(address);
    }
}
