package com.CoenDV.OudNieuw.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPointsReply {
    int points;
    int rank;
}
