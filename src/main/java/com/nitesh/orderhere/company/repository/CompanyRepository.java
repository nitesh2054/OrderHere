package com.nitesh.orderhere.company.repository;

import com.nitesh.orderhere.company.model.Company;
import com.nitesh.orderhere.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByUser(User user);

    @Query("select c.id from Company c inner join c.companyAddresses ca " +
            "where ca.companyAddressId =:companyAddressId")
    int findCompanyId(@Param("companyAddressId") Integer companyAddressId);

    @Query("select c.id from Company c inner join c.user u " +
            "where u.id =:userId")
    int findCompanyIdByUserID(Integer userId);

    Company findByUser_UserId(int userId);
}
