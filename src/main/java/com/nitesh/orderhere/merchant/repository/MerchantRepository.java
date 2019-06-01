package com.nitesh.orderhere.merchant.repository;

import com.nitesh.orderhere.merchant.model.Merchant;
import com.nitesh.orderhere.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    Merchant findByUser(User user);
}
