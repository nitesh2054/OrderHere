package com.nitesh.orderhere.item.service;

import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.item.repository.ItemRepository;
import com.nitesh.orderhere.merchant.model.Merchant;
import com.nitesh.orderhere.merchant.service.MerchantService;
import com.nitesh.orderhere.user.model.User;
import com.nitesh.orderhere.user.model.UserAccount;
import com.nitesh.orderhere.user.service.UserAccountService;
import com.nitesh.orderhere.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserService userService;

    public void saveItem(Item item,String merchantUserName){

        UserAccount userAccount = this.userAccountService.findByUsername(merchantUserName);

        User user = this.userService.findById(userAccount.getUserId());

        Merchant merchant = this.merchantService.findByUser(user);

        item.setMerchant(merchant);

        this.itemRepository.save(item);
    }

    public List<Item> getAllItemOfCurrentMerchant(String merchantUserName){
        UserAccount userAccount = this.userAccountService.findByUsername(merchantUserName);

        User user = this.userService.findById(userAccount.getUserId());

        Merchant merchant = this.merchantService.findByUser(user);

        return this.itemRepository.findByMerchant(merchant);
    }


}
