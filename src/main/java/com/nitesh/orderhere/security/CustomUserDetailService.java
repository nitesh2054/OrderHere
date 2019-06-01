package com.nitesh.orderhere.security;

import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserAccount;
import com.nitesh.orderhere.user.model.UserRole;
import com.nitesh.orderhere.user.service.UserAccountService;
import com.nitesh.orderhere.user.service.UserRoleService;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAccount userAccount = this.userAccountService.findByUsername(username);

        if (userAccount==null){
            throw new UsernameNotFoundException("User with username"+username+" not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        User user = this.userService.findById(userAccount.getUserId());

        List<UserRole> userRoles=  this.userRoleService.findUserRoleByUser(user);

        for (UserRole userRole: userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getUserRole()));
        }

        return new org.springframework.security.core.userdetails.User(username, userAccount.getPassword(), authorities);
    }
}
