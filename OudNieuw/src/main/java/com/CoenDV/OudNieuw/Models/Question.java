package com.CoenDV.OudNieuw.Models;

import com.CoenDV.OudNieuw.Models.Enums.ObjectType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private int questionId;
    private String question;
    private String answer;
    private List<String> options;
    private String explanation;
    private ObjectType objectType;
}
