package com.nitesh.orderhere.item.controller;

import com.nitesh.orderhere.item.model.Item;
import com.nitesh.orderhere.item.service.ItemService;
import com.nitesh.orderhere.security.IAuthenticationFascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private IAuthenticationFascade authenticationFascade;

    @PostMapping(value = "/merchant/item")
    public ModelAndView addItemInfo(@ModelAttribute("itemObject")Item item){
        String merchantUserName=authenticationFascade.getAuthentication().getName();
        this.itemService.saveItem(item, merchantUserName);
        return new ModelAndView("redirect:/merchant/home");
    }

    @GetMapping(value="/merchant/items")
    public String allItemOfCurrentMerchant(Model model){
        String merchantUserName = authenticationFascade.getAuthentication().getName();
        List<Item> items=this.itemService.getAllItemOfCurrentMerchant(merchantUserName);
        System.out.println(items);
        model.addAttribute("items", items);
        return "itemMerchant";
    }

}
