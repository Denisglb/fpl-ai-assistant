package com.example.fpl_assitant.controller;

import com.example.fpl_assitant.dto.*;
import com.example.fpl_assitant.model.Player;
import com.example.fpl_assitant.model.TeamPick;
import com.example.fpl_assitant.services.PlayerSyncService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FplApiClient {

    private final WebClient webClient;
    private final PlayerMapper playerMapper;
    private final TeamPickMapper teamPickMapper;

    public FplApiClient(@Qualifier("fplWebClient") WebClient webClient, PlayerMapper playerMapper, TeamPickMapper teamPickMapper) {
        this.webClient = webClient;
        this.playerMapper = playerMapper;
        this.teamPickMapper = teamPickMapper;
    }

    public List<Player> getPlayers() {
        List<PlayerDto> playerDtos = webClient.get().uri("/bootstrap-static/").retrieve().bodyToMono(BootstrapResponseDto.class).block().getElements();
        return playerDtos.stream().map(playerMapper::toEntity).collect(Collectors.toList());
    }

    public List<TeamPick> getTeamForWeek(long teamId, long gameWeek) {
        List<TeamPickDto> teamPickDtos = webClient.get().uri("/entry/{teamId}/event/{gameWeek}/picks/", teamId, gameWeek).retrieve().bodyToMono(TeamResponseDto.class).block().getPicks();
        return teamPickDtos.stream().map(teamPickMapper::toEntity).peek(teamPick -> {
                    teamPick.setTeamId(teamId);
                    teamPick.setGameWeek(gameWeek);
                })
                .collect(Collectors.toList());
    }
}
