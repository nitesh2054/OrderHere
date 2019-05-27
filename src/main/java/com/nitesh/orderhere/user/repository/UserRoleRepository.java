package com.nitesh.orderhere.user.repository;

import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
