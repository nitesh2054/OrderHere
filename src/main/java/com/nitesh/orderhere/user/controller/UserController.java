package com.nitesh.orderhere.user.controller;

import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.service.UserAccountService;
import com.nitesh.orderhere.user.service.UserRoleService;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/")
    public String saveUser(@RequestParam("name") String name,
                           @RequestParam("address") String address,
                           @RequestParam("phoneNo") String phoneNo,
                           @RequestParam("email") String email,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam(value = "userMerchant", required = false) String isMerchant,
                           @RequestParam("role") String role, Model model)  {

        User user=userService.saveUser(name, address, phoneNo, email, username, password, role);

        if(null==isMerchant){
            return "login";
        }

        if(isMerchant.equals("merchant")){
            model.addAttribute("user",user);
            return "merchantdetails";
        }

        return "login";
    }
}
