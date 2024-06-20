package com.CoenDV.OudNieuw.Services;

import com.CoenDV.OudNieuw.Models.ShopItem;
import com.CoenDV.OudNieuw.Repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopItem> getShopItems() {
        return shopRepository.findAll();
    }
}
