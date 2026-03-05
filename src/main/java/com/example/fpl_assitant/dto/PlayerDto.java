package com.example.fpl_assitant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PlayerDto {

    private String id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("second_name")
    private String secondName;
    private String team;
    @JsonProperty("element_type")
    private String position;
    @JsonProperty("total_points")
    private String totalPoints;
    private String form;
    @JsonProperty("points_per_game")
    private double pointsPerGame;
    @JsonProperty("selected_by_percent")
    private String selectedByPercent;
    @JsonProperty("now_cost")
    private int cost;
    private int minutes;
    @JsonProperty("goals_scored")
    private int goalsScored;
    private int assists;
    @JsonProperty("clean_sheets")
    private int cleanSheets;
}