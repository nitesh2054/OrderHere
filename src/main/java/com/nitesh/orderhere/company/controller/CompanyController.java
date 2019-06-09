package com.nitesh.orderhere.company.controller;

import com.nitesh.orderhere.company.model.Company;
import com.nitesh.orderhere.company.service.CompanyService;
import com.nitesh.orderhere.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/saveCompany")
    public ModelAndView saveMerchant(HttpServletRequest request,
                                     @ModelAttribute("companyObject") Company company,
                                     @RequestParam("country") String country,
                                     @RequestParam("state") String district,
                                     @RequestParam("municipality") String municipality,
                                     @RequestParam("city") String city,
                                     @RequestParam("state") String state){

        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");

        this.companyService.saveCompany(company, user, country, district, municipality, city, state);

        request.getSession().invalidate();

        return new ModelAndView("redirect:/login");
    }


}
