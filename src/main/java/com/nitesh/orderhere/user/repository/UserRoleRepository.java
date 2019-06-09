package com.nitesh.orderhere.user.repository;

import com.nitesh.orderhere.user.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query("select r from UserRole r inner join r.user u " +
            "where u.userId = :userId")
    List<UserRole> findByUserId(@Param("userId") Integer userId);
}
