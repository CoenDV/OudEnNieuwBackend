package com.CoenDV.OudNieuw.Controllers;

import com.CoenDV.OudNieuw.Models.DTO.BuyRequest;
import com.CoenDV.OudNieuw.Models.ShopItem;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Services.ShopService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("buy")
    public User buyItem(@RequestBody BuyRequest item) {
        return shopService.buyItem(item);
    }
}
