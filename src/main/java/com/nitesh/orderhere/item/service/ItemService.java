package com.nitesh.orderhere.item.service;

import com.nitesh.orderhere.company.model.CompanyAddress;
import com.nitesh.orderhere.company.service.CompanyAddressService;
import com.nitesh.orderhere.item.model.AvailableItemOnCompanyAddress;
import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.item.repository.AvailableItemOnAddressRepository;
import com.nitesh.orderhere.item.repository.ItemIdName;
import com.nitesh.orderhere.item.repository.ItemRepository;
import com.nitesh.orderhere.company.model.Company;
import com.nitesh.orderhere.company.service.CompanyService;
import com.nitesh.orderhere.user.model.Address;
import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserAccount;
import com.nitesh.orderhere.user.service.UserAccountService;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserService userService;

    @Autowired
    private AvailableItemOnAddressRepository availableItemOnAddressRepository;

    @Autowired
    private CompanyAddressService companyAddressService;

    public void saveItem(Item item,String merchantUserName){

        User user = this.userService.findByUserName(merchantUserName);
        Company company = this.companyService.findByUser(user);
        item.setCompany(company);
        this.itemRepository.save(item);

        List<CompanyAddress> companyAddresses = this.companyAddressService.findByCompany(company);

        for (CompanyAddress companyAddress:
             companyAddresses) {
            AvailableItemOnCompanyAddress availableItemOnCompanyAddress = new AvailableItemOnCompanyAddress();
            availableItemOnCompanyAddress.setCompanyAddress(companyAddress);
            availableItemOnCompanyAddress.setItem(item);
            if(companyAddresses.get(0)==companyAddress){
                availableItemOnCompanyAddress.setAvailableItemOnThisAddress(item.getAvailableNumber());
            }
            companyAddress.getAvailableItemOnCompanyAddress().add(availableItemOnCompanyAddress);
            this.availableItemOnAddressRepository.save(availableItemOnCompanyAddress);
        }

        company.getItems().add(item);
        this.companyService.saveCompany(company);
    }

    public List<Item> getAllItemOfCurrentMerchant(String merchantUserName){
        UserAccount userAccount = this.userAccountService.findByUsername(merchantUserName);

        User user = this.userService.findById(userAccount.getUserId());

        Company company = this.companyService.findByUser(user);

        return this.itemRepository.findByCompany(company);
    }

    public List<Item> findByCompany(Company company) {
       return this.itemRepository.findByCompany(company);
    }
}
