package com.nitesh.orderhere.user.repository;

import com.nitesh.orderhere.user.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<Address, Integer> {
}
