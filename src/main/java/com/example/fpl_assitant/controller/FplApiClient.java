package com.example.fpl_assitant.controller;

import com.example.fpl_assitant.dto.BootstrapResponseDto;
import com.example.fpl_assitant.dto.PlayerDto;
import com.example.fpl_assitant.dto.PlayerMapper;
import com.example.fpl_assitant.model.Player;
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

    public FplApiClient(@Qualifier("fplWebClient") WebClient webClient, PlayerMapper playerMapper) {
        this.webClient = webClient;
        this.playerMapper = playerMapper;
    }

    public List<Player> getPlayers() {
        List<PlayerDto> playerDtos = webClient.get().uri("/bootstrap-static/").retrieve().bodyToMono(BootstrapResponseDto.class).block().getElements();
        return playerDtos.stream().map(playerMapper::toEntity).collect(Collectors.toList());
    }

    public String getTeamForWeek(long teamId, long gameWeek) {
        return webClient.get().uri("/entry/{teamId}/event/{gameWeek}/picks/", teamId, gameWeek).retrieve().bodyToMono(String.class).block();
    }
}
