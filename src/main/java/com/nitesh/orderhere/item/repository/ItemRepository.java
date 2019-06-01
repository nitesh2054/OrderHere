package com.nitesh.orderhere.item.repository;

import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.merchant.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByMerchant(Merchant merchant);
}
