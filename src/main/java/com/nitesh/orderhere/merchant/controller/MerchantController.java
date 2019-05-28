package com.nitesh.orderhere.merchant.controller;

import com.nitesh.orderhere.merchant.model.Merchant;
import com.nitesh.orderhere.merchant.service.MerchantService;
import com.nitesh.orderhere.user.model.User;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping(value = "/")
    public String saveMerchant(HttpServletRequest request, @ModelAttribute("merchantObject") Merchant merchant, Model model){

        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");

        System.out.println(user.getUserRole());

        this.merchantService.saveMerchant(merchant, user);

        request.getSession().invalidate();

        return "login";
    }
}
