package com.nitesh.orderhere.user.service;

import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserRole;
import com.nitesh.orderhere.user.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> findByUserId(int userId){
        return this.userRoleRepository.findByUserId(userId);
    }


}
