package com.nitesh.orderhere.item.service;

import com.nitesh.orderhere.company.model.Company;
import com.nitesh.orderhere.company.model.CompanyAddress;
import com.nitesh.orderhere.company.service.CompanyAddressService;
import com.nitesh.orderhere.company.service.CompanyService;
import com.nitesh.orderhere.item.model.AvailableItemOnCompanyAddress;
import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.item.repository.AvailableItemOnAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableItemOnAddressService {

    @Autowired
    AvailableItemOnAddressRepository availableItemOnAddressRepository;

    @Autowired
    CompanyAddressService companyAddressService;

    @Autowired
    ItemService itemService;

    @Autowired
    CompanyService companyService;
    public List<Object []> findAvailableItemByCompanyAddressId(int companyAddressId) {
        return this.availableItemOnAddressRepository.findAvailableItemIdByCompanyId(companyAddressId);
    }

    public void save(AvailableItemOnCompanyAddress availableItemOnCompanyAddress) {
        this.availableItemOnAddressRepository.save(availableItemOnCompanyAddress);
    }
}
