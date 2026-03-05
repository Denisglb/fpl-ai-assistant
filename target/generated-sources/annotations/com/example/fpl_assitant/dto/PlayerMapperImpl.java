package com.example.fpl_assitant.dto;

import com.example.fpl_assitant.model.Player;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-05T18:39:12+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public Player toEntity(PlayerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        player.firstName( dto.getFirstName() );
        player.secondName( dto.getSecondName() );
        player.team( dto.getTeam() );
        player.position( dto.getPosition() );
        player.pointsPerGame( dto.getPointsPerGame() );
        player.minutes( dto.getMinutes() );
        player.goalsScored( dto.getGoalsScored() );
        player.assists( dto.getAssists() );
        player.cleanSheets( dto.getCleanSheets() );

        player.id( Long.parseLong(dto.getId()) );
        player.cost( dto.getCost() / 10.0 );
        player.form( Double.parseDouble(dto.getForm()) );
        player.selectedByPercent( Double.parseDouble(dto.getSelectedByPercent()) );
        player.totalPoints( Integer.parseInt(dto.getTotalPoints()) );

        return player.build();
    }
}
