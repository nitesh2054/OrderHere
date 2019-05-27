package com.nitesh.orderhere.user.service;

import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserAccount;
import com.nitesh.orderhere.user.model.UserRole;
import com.nitesh.orderhere.user.repository.UserAccountRepository;
import com.nitesh.orderhere.user.repository.UserRepository;
import com.nitesh.orderhere.user.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(String name, String address, String phoneNo, String email, String username, String password, String role){

        //saving user
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setPhoneNo(phoneNo);
        user.setEmail(email);

        user.setUserRole(new ArrayList<UserRole>());
        UserRole userRole = new UserRole();
        UserRole userRole2 = new UserRole();
        if(role.equals("user_simple")){
            userRole.setUserRole("USER");
            userRole2.setUserRole("SIMPLE");

        }
        user.getUserRole().add(userRole);
        user.getUserRole().add(userRole2);

        User savedUser=userRepository.save(user);

        UserAccount userAccount = new UserAccount();
        userAccount.setUser(savedUser);
        userAccount.setUserName(username);
        userAccount.setPassword(passwordEncoder.encode(password));
        userAccountRepository.save(userAccount);

        return savedUser;
    }

    public User findById(int id){
        return this.userRepository.findById(id).get();
    }
}