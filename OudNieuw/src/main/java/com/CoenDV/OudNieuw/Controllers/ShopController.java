package com.CoenDV.OudNieuw.Controllers;

import com.CoenDV.OudNieuw.Models.ShopItem;
import com.CoenDV.OudNieuw.Services.ShopService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("shop")
public class ShopController {

    ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<ShopItem> getShopItems() {
        return shopService.getShopItems();
    }

}
