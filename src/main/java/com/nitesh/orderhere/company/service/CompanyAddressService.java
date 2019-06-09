package com.nitesh.orderhere.company.service;

import com.nitesh.orderhere.company.model.Company;
import com.nitesh.orderhere.company.model.CompanyAddress;
import com.nitesh.orderhere.company.repository.CompanyAddressRepository;
import com.nitesh.orderhere.item.model.AvailableItemOnCompanyAddress;
import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.item.service.ItemService;
import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyAddressService {

    @Autowired
    private CompanyAddressRepository companyAddressRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    public List<CompanyAddress> findAllAddressesOfCompany(String userName) {
        User user = this.userService.findByUserName(userName);
        Company company = this.companyService.findByUser(user);
        return this.companyAddressRepository.findByCompany(company);
    }

    public int CountByCompany(Company company) {
        return this.companyAddressRepository.countByCompany(company);
    }

    public List<CompanyAddress> findByCompany(Company company) {
        return this.companyAddressRepository.findByCompany(company);
    }

    public void saveCompanyAddress(CompanyAddress companyAddress, String userName) {


        User user = this.userService.findByUserName(userName);

        Company company = this.companyService.findByUser(user);


        List<Item> items = this.itemService.findByCompany(company);

        if(items==null){
            items = new ArrayList<>();
        }

        if(companyAddress.getAvailableItemOnCompanyAddress()==null){
            companyAddress.setAvailableItemOnCompanyAddress(new ArrayList<>());
        }


        if(items!=null) {
            for (Item item :
                    items) {
                AvailableItemOnCompanyAddress availableItemOnCompanyAddress = new AvailableItemOnCompanyAddress();
                availableItemOnCompanyAddress.setItem(item);
                availableItemOnCompanyAddress.setCompanyAddress(companyAddress);
                companyAddress.getAvailableItemOnCompanyAddress().add(availableItemOnCompanyAddress);
            }
        }

        companyAddress.setCompany(company);
        company.getCompanyAddresses().add(companyAddress);
        this.companyService.saveCompany(company);
    }
}
