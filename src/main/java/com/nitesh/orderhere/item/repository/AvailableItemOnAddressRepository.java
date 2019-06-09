package com.nitesh.orderhere.item.repository;

import com.nitesh.orderhere.company.model.CompanyAddress;
import com.nitesh.orderhere.item.model.AvailableItemOnCompanyAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvailableItemOnAddressRepository extends JpaRepository<AvailableItemOnCompanyAddress, Integer> {

    @Query("select a.availableItemId, a.availableItemOnThisAddress, i.itemName "+
            "from AvailableItemOnCompanyAddress a inner join a.item i "+
            "inner join a.companyAddress ca "+
            "where ca.companyAddressId =:companyAddressId")
    List<Object []> findAvailableItemIdByCompanyId(@Param("companyAddressId") Integer
                                                           companyAddressId);

    int countByCompanyAddress(CompanyAddress companyAddress);
}
