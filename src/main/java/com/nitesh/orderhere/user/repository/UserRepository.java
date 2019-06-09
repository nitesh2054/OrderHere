package com.nitesh.orderhere.user.repository;


import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u.userId from User u inner join u.userAccount ua " +
            "where ua.userName=:userName")
    int findUserIdByUserName(String userName);
}
