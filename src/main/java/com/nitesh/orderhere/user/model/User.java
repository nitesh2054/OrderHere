package com.nitesh.orderhere.user.model;


import com.nitesh.orderhere.company.model.Company;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int userId;

    @Column(name = "FullName")
    private String name;

    @Column(name = "PhoneNo")
    private String phoneNo;

    @Column(name="Email")
    private String email;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserRole> userRole;

    @OneToOne(mappedBy = "user")
    private Company company;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserAccount userAccount;


    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
