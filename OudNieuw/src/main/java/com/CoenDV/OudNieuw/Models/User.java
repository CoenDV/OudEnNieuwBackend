package com.CoenDV.OudNieuw.Models;

import com.CoenDV.OudNieuw.Models.Enums.Role;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private int userId;
    private String username;
    private Role role;
    private int points;
    @OneToOne
    private Challenge activeChallenge;
}
