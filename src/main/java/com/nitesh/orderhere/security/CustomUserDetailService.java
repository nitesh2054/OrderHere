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
    private UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserAccount userAccount = this.userAccountService.findByUsername(userName);

        if (userAccount==null){
            throw new UsernameNotFoundException("User with username"+userName+" not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        List<UserRole> userRoles=this.userRoleService.findByUserId(userAccount.getUserId());

        for (UserRole userRole: userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getUserRole()));
        }

        return new org.springframework.security.core.userdetails.User(userName, userAccount.getPassword(), authorities);
    }
}
