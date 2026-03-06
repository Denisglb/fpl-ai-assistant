package com.example.fpl_assitant.dto;

import com.example.fpl_assitant.model.TeamPick;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamPickMapper {

    @Mapping(target = "playerId", source= "")
    TeamPick toEntity(TeamPickDto teamPickDto);

}
