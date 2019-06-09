package com.nitesh.orderhere.user.service;

import com.nitesh.orderhere.user.model.Address;
import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserAccount;
import com.nitesh.orderhere.user.model.UserRole;
import com.nitesh.orderhere.user.repository.UserAddressRepository;
import com.nitesh.orderhere.user.repository.UserAccountRepository;
import com.nitesh.orderhere.user.repository.UserRepository;
import com.nitesh.orderhere.user.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private UserAccountService userAccountService;

    public User saveUser(String name,String country, String state,String district, String municipality, String city,
                         String phoneNo, String email, String username, String password, String role){

        //saving user
        User user = new User();
        user.setName(name);
        user.setPhoneNo(phoneNo);
        user.setEmail(email);

        user.setUserRole(new ArrayList<UserRole>());
        UserRole userRole = new UserRole();
        if(role.equals("user_simple")){
            userRole.setUserRole("USER");
        }
        user.getUserRole().add(userRole);
        userRole.setUser(user);

        User savedUser=userRepository.save(user);

        UserAccount userAccount = new UserAccount();
        userAccount.setUser(savedUser);
        userAccount.setUserName(username);
        userAccount.setPassword(passwordEncoder.encode(password));
        userAccountService.saveUserAccount(userAccount);


        Address address = new Address();
        address.setUser(savedUser);
        address.setCountry(country);
        address.setState(state);
        address.setMunicipality(municipality);
        address.setDistrict(district);
        address.setCity(city);
        userAddressService.saveAddress(address);
        return savedUser;
    }

    public User findById(int id){
        return this.userRepository.findById(id).get();
    }

    public User saveUser(User user){
        return this.userRepository.save(user);
    }

    public User findByUserName(String userName) {
        UserAccount userAccount=userAccountService.findByUsername(userName);
        return this.userRepository.findById(userAccount.getUserId()).get();
    }
}