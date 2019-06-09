package com.nitesh.orderhere.company.repository;

import com.nitesh.orderhere.company.model.Company;
import com.nitesh.orderhere.company.model.CompanyAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyAddressRepository extends JpaRepository<CompanyAddress, Integer> {
    List<CompanyAddress> findByCompany_CompanyId(int companyId);

    int countByCompany(Company company);

    List<CompanyAddress> findByCompany(Company company);
}
