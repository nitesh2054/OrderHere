package com.nitesh.orderhere.user.controller;

import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.service.UserAccountService;
import com.nitesh.orderhere.user.service.UserRoleService;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/saveUser")
    public ModelAndView saveUser(@RequestParam("name") String name,
                                 @RequestParam("country") String country,
                                 @RequestParam("state") String state,
                                 @RequestParam("district") String district,
                                 @RequestParam("municipality") String municipality,
                                 @RequestParam("city") String city,
                                 @RequestParam("phoneNo") String phoneNo,
                                 @RequestParam("email") String email,
                                 @RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam(value = "userMerchant", required = false) String isMerchant,
                                 @RequestParam("role") String role, Model model)  {

        User user=userService.saveUser(name, country, state, district, municipality,city,
                phoneNo, email, username, password, role);

        if(null==isMerchant){
            return new ModelAndView("redirect:/login");
        }

        if(isMerchant.equals("merchant")){
            model.addAttribute("user",user);
            return new ModelAndView("redirect:/signup/company");

        }

        return new ModelAndView("redirect:/login");
    }
}