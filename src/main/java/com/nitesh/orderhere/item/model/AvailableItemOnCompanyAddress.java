package com.nitesh.orderhere.item.model;

import com.nitesh.orderhere.company.model.CompanyAddress;

import javax.persistence.*;

@Entity
@Table(name="available_item_on_address")
public class AvailableItemOnCompanyAddress {
    @Id
    @Column(name = "AvailableItemId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availableItemId;

    @OneToOne
    @JoinColumn(name = "ItemId")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "CompanyAddressId")
    private CompanyAddress companyAddress;

    @Column(name = "AvailableItemOnThisAddress")
    private int availableItemOnThisAddress;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public CompanyAddress getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(CompanyAddress companyAddress) {
        this.companyAddress = companyAddress;
    }

    public int getAvailableItemOnThisAddress() {
        return availableItemOnThisAddress;
    }

    public void setAvailableItemOnThisAddress(int availableItemOnThisAddress) {
        this.availableItemOnThisAddress = availableItemOnThisAddress;
    }

    public int getAvailableItemId() {
        return availableItemId;
    }

    public void setAvailableItemId(int availableItemId) {
        this.availableItemId = availableItemId;
    }
}
