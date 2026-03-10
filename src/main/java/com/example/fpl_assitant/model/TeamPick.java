package com.example.fpl_assitant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeamPick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long teamId;
    private long gameWeek;
    private long playerId;
    private int position;
    private int multiplier;
    private boolean captain;
    private boolean viceCaptain;

}
