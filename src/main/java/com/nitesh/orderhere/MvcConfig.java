package com.nitesh.orderhere;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup/company").setViewName("detailsCompany");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/user/home").setViewName("homeUser");
        registry.addViewController("/company/home").setViewName("homeCompany");
        registry.addViewController("/company/iteminfo").setViewName("addItem");
        registry.addViewController("/company/addressinfo").setViewName("addressInfoCompany");
    }
}
