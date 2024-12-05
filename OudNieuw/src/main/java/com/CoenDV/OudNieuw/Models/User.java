package com.CoenDV.OudNieuw.Models;

import com.CoenDV.OudNieuw.Models.Enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private int userId;
    private String username;
    private String password;
    private Role role;
    private int points;
    @OneToOne
    private Challenge activeChallenge;

    // stats
    private int correctAnswers;
    private int itemsBought;
    private int totalPoints;
}
