package com.example.fpl_assitant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamPickDto {

    private int element;
    private int position;
    private int multiplier;
    @JsonProperty("is_captain")
    private boolean captain;
    @JsonProperty("is_vice_captain")
    private boolean viceCaptain;

}
