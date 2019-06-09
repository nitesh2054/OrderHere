package com.nitesh.orderhere.company.model;

import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.user.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CompanyId")
    private int companyId;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "Category")
    private String category;

    @Column(name="Details")
    private String details;

    @Column(name = "CompanyType")
    private String companyType;

    @OneToOne
    @JoinColumn(name="UserId")
    private User user;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CompanyAddress> companyAddresses;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<CompanyAddress> getCompanyAddresses() {
        return companyAddresses;
    }

    public void setCompanyAddresses(List<CompanyAddress> companyAddresses) {
        this.companyAddresses = companyAddresses;
    }
}
