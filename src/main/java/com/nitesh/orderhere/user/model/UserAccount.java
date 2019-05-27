package com.nitesh.orderhere.user.model;

import javax.persistence.*;

@Entity
@Table(name = "users_account")
public class UserAccount {

    @Id
    @Column(name="UserId")
    private int userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name="UserPassword")
    private String password;

    @OneToOne
    @JoinColumn(name = "UserId")
    @MapsId
    private User user;

    public UserAccount() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
