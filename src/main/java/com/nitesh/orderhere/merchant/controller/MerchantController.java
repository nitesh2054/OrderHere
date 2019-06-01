package com.nitesh.orderhere.merchant.controller;

import com.nitesh.orderhere.merchant.model.Merchant;
import com.nitesh.orderhere.merchant.service.MerchantService;
import com.nitesh.orderhere.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping(value = "/saveMerchant")
    public ModelAndView saveMerchant(HttpServletRequest request, @ModelAttribute("merchantObject") Merchant merchant){

        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");

        this.merchantService.saveMerchant(merchant, user);

        request.getSession().invalidate();

        return new ModelAndView("redirect:/login");
    }
}
