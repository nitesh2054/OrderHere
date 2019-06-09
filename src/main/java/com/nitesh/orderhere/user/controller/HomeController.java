package com.nitesh.orderhere.user.controller;

import com.nitesh.orderhere.security.IAuthenticationFascade;
import com.nitesh.orderhere.user.service.UserAccountService;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Collection;

@Controller
public class HomeController {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserService userService;

    @Autowired
    private IAuthenticationFascade authenticationFascade;

    @GetMapping("/homePage")
    public ModelAndView userType(){

        Authentication authentication = authenticationFascade.getAuthentication();

        Collection<? extends GrantedAuthority>authorities= authentication.getAuthorities();

        for (GrantedAuthority authority:
                authorities) {
            if( authority.getAuthority().equals("MERCHANT")){
                return new ModelAndView("redirect:/company/home");
            }
        }

        return new ModelAndView("redirect:/user/home");

    }
}
