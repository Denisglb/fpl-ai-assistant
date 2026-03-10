package com.example.fpl_assitant.services;

import com.example.fpl_assitant.config.WebClientConfig;
import com.example.fpl_assitant.controller.FplApiClient;
import com.example.fpl_assitant.db.PlayerRepository;
import com.example.fpl_assitant.model.Player;
import com.example.fpl_assitant.model.TeamPick;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class SuggestionService {

    private final FplApiClient fplApiClient;
    private final PlayerRepository playerRepository;
    private final ChatClient chatClient;


    public String getSuggestion(long teamId, long gameWeek) {
        List<TeamPick> teamPickList = fplApiClient.getTeamForWeek(teamId, gameWeek);

        List<Long> playerIds = teamPickList.stream()
                .map(TeamPick::getPlayerId)
                .toList();

        List<Player> players = playerRepository.findAllById(playerIds);
//        log.info("players {}", players);

        String playerContext = players.stream()
                .map(p -> String.format("%s %s - Position: %s, Cost: %.1f, Form: %.1f, Points: %d, Goals: %d, Assists: %d",
                        p.getFirstName(), p.getSecondName(), p.getPosition(),
                        p.getCost(), p.getForm(), p.getTotalPoints(),
                        p.getGoalsScored(), p.getAssists()))
                .collect(Collectors.joining("\n"));

        String prompt = """
                You are an FPL (Fantasy Premier League) assistant.
                Here is my current team for gameweek %d:
                
                %s
                
                Please suggest:
                1. Who I should captain
                2. Any transfer suggestions based on form and value
                3. Any differential picks worth considering
                """.formatted(gameWeek, playerContext);


        return chatClient.prompt().user(prompt).call().content();

    }

}
