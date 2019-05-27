package com.nitesh.orderhere.user.service;

import com.nitesh.orderhere.user.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;


}
