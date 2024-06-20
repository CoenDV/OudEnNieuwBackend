package com.CoenDV.OudNieuw.Repositories;

import com.CoenDV.OudNieuw.Models.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopItem, Integer> {
}
