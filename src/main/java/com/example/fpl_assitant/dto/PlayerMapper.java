package com.example.fpl_assitant.dto;

import com.example.fpl_assitant.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "id", expression = "java(Long.parseLong(dto.getId()))")
    @Mapping(target = "cost", expression = "java(dto.getCost() / 10.0)")
    @Mapping(target = "form", expression = "java(Double.parseDouble(dto.getForm()))")
    @Mapping(target = "selectedByPercent", expression = "java(Double.parseDouble(dto.getSelectedByPercent()))")
    @Mapping(target = "totalPoints", expression = "java(Integer.parseInt(dto.getTotalPoints()))")
    Player toEntity(PlayerDto dto);

}

//TODO: add tests for logic, null cases