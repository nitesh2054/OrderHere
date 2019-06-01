package com.nitesh.orderhere.merchant.service;

import com.nitesh.orderhere.merchant.model.Merchant;
import com.nitesh.orderhere.merchant.repository.MerchantRepository;
import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserRole;
import com.nitesh.orderhere.user.repository.UserRepository;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private UserService userService;

    public Merchant saveMerchant(Merchant merchant, User user) {
        merchant.setUser(user);

        UserRole userRole = new UserRole();
        userRole.setUserRole("MERCHANT");

        user.getUserRole().add(userRole);
        userRole.setUser(user);
        userService.saveUser(user);

        return this.merchantRepository.save(merchant);
    }

    public Merchant findByUser(User user){
        return this.merchantRepository.findByUser(user);
    }


}
