package com.nitesh.orderhere.user.model;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @Column(name = "UserId")
    private int userId;

    @OneToOne
    @JoinColumn(name = "UserId")
    @MapsId
    private User user;

    @Column(name = "Country")
    private String country;
    @Column(name="State")
    private String state;
    @Column(name="District")
    private String district;
    @Column(name="Municipality")
    private String municipality;
    @Column(name="City")
    private String city;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}