package com.nitesh.orderhere.item.repository;


import com.nitesh.orderhere.item.model.AvailableItemOnCompanyAddress;

public interface ItemIdName {
    int getItemId();
    String getItemName();
    AvailableItemOnCompanyAddress getAvailableItemOnCompanyAddress();
}
