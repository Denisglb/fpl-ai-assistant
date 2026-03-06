package com.example.fpl_assitant.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TeamResponseDto {

    private List<TeamPickDto> picks;

}
