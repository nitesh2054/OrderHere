package com.nitesh.orderhere.user.service;

import com.nitesh.orderhere.user.model.UserAccount;
import com.nitesh.orderhere.user.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public UserAccount findByUsername(String username){
        return this.userAccountRepository.findByUserName(username);
    }
}
