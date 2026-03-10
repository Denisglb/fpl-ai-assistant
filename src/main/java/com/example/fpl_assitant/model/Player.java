package com.example.fpl_assitant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Getter
public class Player {

    @Id
    private long id;
    private String firstName;
    private String secondName;
    private String team;
    private String position;
    private int totalPoints;
    private double form;
    private double pointsPerGame;
    private double selectedByPercent;
    private double cost;
    private int minutes;
    private int goalsScored;
    private int assists;
    private int cleanSheets;
}
