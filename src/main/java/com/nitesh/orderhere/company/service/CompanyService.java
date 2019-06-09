package com.nitesh.orderhere.company.service;

import com.nitesh.orderhere.company.model.Company;
import com.nitesh.orderhere.company.model.CompanyAddress;
import com.nitesh.orderhere.company.repository.CompanyRepository;
import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserRole;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserService userService;

    public Company saveCompany(Company company, User user,
                                String country,String district,String  municipality,String city,String state) {
        company.setUser(user);

        UserRole userRole = new UserRole();
        userRole.setUserRole("MERCHANT");

        user.getUserRole().add(userRole);
        userRole.setUser(user);
        userService.saveUser(user);

        CompanyAddress address = new CompanyAddress();

        address.setCountry(country);
        address.setDistrict(district);
        address.setMunicipality(municipality);
        address.setCity(city);
        address.setState(state);
        address.setCompany(company);
        company.setCompanyAddresses(new ArrayList<>());
        company.getCompanyAddresses().add(address);
        company.setItems(new ArrayList<>());

        return this.companyRepository.save(company);
    }



    public Company findByUser(User user){
        return this.companyRepository.findByUser(user);
    }

    public void saveCompany(Company company) {
        this.companyRepository.save(company);
    }

}
