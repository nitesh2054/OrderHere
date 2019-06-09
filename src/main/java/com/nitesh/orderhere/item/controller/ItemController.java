package com.nitesh.orderhere.item.controller;

import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.item.service.AvailableItemOnAddressService;
import com.nitesh.orderhere.item.service.ItemService;
import com.nitesh.orderhere.security.IAuthenticationFascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private AvailableItemOnAddressService availableItemOnAddressService;

    @Autowired
    private IAuthenticationFascade authenticationFascade;

    @PostMapping(value = "/company/item")
    public ModelAndView addItemInfo(@ModelAttribute("itemObject")Item item){
        String merchantUserName=authenticationFascade.getAuthentication().getName();
        this.itemService.saveItem(item, merchantUserName);
        return new ModelAndView("redirect:/company/items");
    }

    @GetMapping(value="/company/items")
    public String allItemOfCurrentMerchant(Model model){
        String merchantUserName = authenticationFascade.getAuthentication().getName();
        List<Item> items=this.itemService.getAllItemOfCurrentMerchant(merchantUserName);
        model.addAttribute("items", items);
        return "itemsCompany";
    }

    @GetMapping("/company/items/address/{id}")
    public String itemAvailabilityOfCurrentAddress(@PathVariable("id") int companyAddressId,Model model){
        List<Object []> availableItems=this.availableItemOnAddressService.findAvailableItemByCompanyAddressId(companyAddressId);
        model.addAttribute("availableItems",availableItems);
        return "ItemAvailabilityAddressCompany";
    }

}
