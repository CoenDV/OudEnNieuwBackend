package com.CoenDV.OudNieuw.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPointsRequest {
    String username;
    int points;
}
