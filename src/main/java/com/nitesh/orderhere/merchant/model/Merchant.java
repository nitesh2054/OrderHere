package com.nitesh.orderhere.merchant.model;

import com.nitesh.orderhere.user.model.User;

import javax.persistence.*;

@Entity
@Table(name="merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MerchantId")
    private int merchantId;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "CompanyAddress")
    private String companyAddress;

    @Column(name = "Category")
    private String category;

    @Column(name="Details")
    private String details;

    @Column(name = "MerchantType")
    private String merchantType;

    @OneToOne
    @JoinColumn(name="UserId")
    private User user;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
