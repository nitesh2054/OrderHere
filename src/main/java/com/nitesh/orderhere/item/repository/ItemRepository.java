package com.nitesh.orderhere.item.repository;

import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface ItemRepository extends JpaRepository<Item, Integer> {
     List<Item> findByCompany(Company company);
}
