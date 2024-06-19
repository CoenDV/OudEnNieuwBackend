package com.CoenDV.OudNieuw.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
public class Challenge {
    @Id
    private int challengeId;
    private String title;
    private String explanation;
    private LocalTime deadline;
}
