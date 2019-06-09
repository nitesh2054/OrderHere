package com.nitesh.orderhere.item.model;

import com.nitesh.orderhere.company.model.Company;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ItemId")
    private int itemId;

    @Column(name = "ItemName")
    private String itemName;

    @Column(name = "SellingItemUnit")
    private String sellingItemUnit;

    @Column(name = "SellingItemUnitEqualsInSingleNumber")
    private int sellingItemUnitEqualsInSingleNumber;

    @Column(name="ItemPrice")
    private double itemTotalPrice;

    @Column(name = "AvailableNumber")
    private int availableNumber;

    @Column(name = "SingleMeasurementUnitOfItem")
    private String measurementUnitOfItem;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDate")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate")
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "CompanyId")
    private Company company;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSellingItemUnit() {
        return sellingItemUnit;
    }

    public void setSellingItemUnit(String sellingItemUnit) {
        this.sellingItemUnit = sellingItemUnit;
    }

    public int getSellingItemUnitEqualsInSingleNumber() {
        return sellingItemUnitEqualsInSingleNumber;
    }

    public void setSellingItemUnitEqualsInSingleNumber(int sellingItemUnitEqualsInSingleNumber) {
        this.sellingItemUnitEqualsInSingleNumber = sellingItemUnitEqualsInSingleNumber;
    }

    public double getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(double itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public int getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(int availableNumber) {
        this.availableNumber = availableNumber;
    }

    public String getMeasurementUnitOfItem() {
        return measurementUnitOfItem;
    }

    public void setMeasurementUnitOfItem(String measurementUnitOfItem) {
        this.measurementUnitOfItem = measurementUnitOfItem;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
