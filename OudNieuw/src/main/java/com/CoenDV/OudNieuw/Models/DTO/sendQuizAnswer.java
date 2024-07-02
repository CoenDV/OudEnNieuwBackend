package com.CoenDV.OudNieuw.Models.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class sendQuizAnswer {
    private int questionId;
    private int userId;
    private int answerId;
}
