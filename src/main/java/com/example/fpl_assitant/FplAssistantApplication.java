package com.example.fpl_assitant;

import com.example.fpl_assitant.controller.FplApiClient;
import com.example.fpl_assitant.model.Player;
import com.example.fpl_assitant.services.PlayerSyncService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FplAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(FplAssistantApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PlayerSyncService playerSyncService) {
		return args -> {
			playerSyncService.syncPlayers();
			System.out.println("Players synced successfully!");
		};
	}
}
