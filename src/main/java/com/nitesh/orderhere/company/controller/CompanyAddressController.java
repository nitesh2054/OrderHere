package com.nitesh.orderhere.company.controller;

import com.nitesh.orderhere.company.model.CompanyAddress;
import com.nitesh.orderhere.company.service.CompanyAddressService;
import com.nitesh.orderhere.security.IAuthenticationFascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CompanyAddressController {

    @Autowired
    private IAuthenticationFascade iAuthenticationFascade;

    @Autowired
    private CompanyAddressService companyAddressService;

    @GetMapping("/company/addresses")
    public String getAddresses(Model model){

        String userName=iAuthenticationFascade.getAuthentication().getName();

        List<CompanyAddress> addresses=this.companyAddressService.findAllAddressesOfCompany(userName);

        model.addAttribute("addresses", addresses);

        return "addressesCompany";
    }

    @PostMapping("/company/address")
    public ModelAndView saveAddress(@ModelAttribute("companyAddressObject") CompanyAddress companyAddress){
        String merchantUserName = iAuthenticationFascade.getAuthentication().getName();
        this.companyAddressService.saveCompanyAddress(companyAddress,merchantUserName);
        return new ModelAndView("redirect:/company/addresses");
    }


}
