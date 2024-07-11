package com.CoenDV.OudNieuw.Models;

import com.CoenDV.OudNieuw.Models.Enums.ObjectType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopItem {
    @Id
    private int itemId;
    private String title;
    private String explanation;
    private int points;
    private ObjectType objectType;
}
