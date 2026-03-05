package com.example.fpl_assitant.services;

import com.example.fpl_assitant.controller.FplApiClient;
import com.example.fpl_assitant.db.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PlayerSyncService {

    private final PlayerRepository playerRepository;
    private final FplApiClient fplApiClient;

    public void syncPlayers() {
        playerRepository.saveAll(fplApiClient.getPlayers());

    }

}
