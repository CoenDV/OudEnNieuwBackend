package com.CoenDV.OudNieuw.Models.DTO;

import com.CoenDV.OudNieuw.Models.User;
import lombok.Data;

@Data
public class AnswerReply {
    private User user;
    private int points;
}
