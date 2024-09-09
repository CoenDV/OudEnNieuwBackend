package com.CoenDV.OudNieuw.Controllers;

import com.CoenDV.OudNieuw.Models.DTO.BuyRequest;
import com.CoenDV.OudNieuw.Models.ShopItem;
import com.CoenDV.OudNieuw.Models.User;
import com.CoenDV.OudNieuw.Services.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/", "https://oudennieuw.onrender.com/", "https://oud-en-nieuw-backend-git-coen-de-vries-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/"})
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
        System.out.println(item);

        if (item.getItemId() == 10) // Mystery Box
            return shopService.buyMysteryBox(item);

        return shopService.buyItem(item);
    }
}
