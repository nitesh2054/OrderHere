package com.nitesh.orderhere.merchant.repository;

import com.nitesh.orderhere.merchant.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
}
