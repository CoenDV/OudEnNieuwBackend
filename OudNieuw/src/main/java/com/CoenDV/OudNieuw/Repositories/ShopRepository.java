package com.CoenDV.OudNieuw.Repositories;

import com.CoenDV.OudNieuw.Models.Enums.ObjectType;
import com.CoenDV.OudNieuw.Models.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopItem, Integer> {

    List<ShopItem> findByObjectTypeNotOrderByPointsAsc(ObjectType objectType);
}
