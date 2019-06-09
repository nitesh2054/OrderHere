package com.nitesh.orderhere.company.model;

import com.nitesh.orderhere.item.model.AvailableItemOnCompanyAddress;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies_address")
public class CompanyAddress {

    @Id
    @Column(name = "CompanyAddressId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyAddressId;

    @Column(name = "Country")
    private String country;
    @Column(name = "State")
    private String state;
    @Column(name = "District")
    private String district;
    @Column(name = "Municipality")
    private String municipality;
    @Column(name = "City")
    private String city;

    @ManyToOne()
    @JoinColumn(name = "CompanyId")
    private Company company;

    @OneToMany(mappedBy = "companyAddress", cascade = CascadeType.ALL)
    private List<AvailableItemOnCompanyAddress> availableItemOnCompanyAddress;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(int companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;

    }

    public List<AvailableItemOnCompanyAddress> getAvailableItemOnCompanyAddress() {
        return availableItemOnCompanyAddress;
    }

    public void setAvailableItemOnCompanyAddress(List<AvailableItemOnCompanyAddress> availableItemOnCompanyAddress) {
        this.availableItemOnCompanyAddress = availableItemOnCompanyAddress;
    }
}


