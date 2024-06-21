package com.CoenDV.OudNieuw.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {
    @Id
    private int challengeId;
    private String challengeCode;
    private String title;
    private String explanation;
    private LocalTime deadline;
    private int points;
    private boolean used;
}
