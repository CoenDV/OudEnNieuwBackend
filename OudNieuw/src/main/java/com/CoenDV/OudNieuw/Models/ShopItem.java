package com.CoenDV.OudNieuw.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ShopItem {
    @Id
    private int itemId;
    private String title;
    private String explanation;
    private int points;
}
