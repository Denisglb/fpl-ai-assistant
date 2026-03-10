package com.example.fpl_assitant;

import com.example.fpl_assitant.services.SuggestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FplAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(FplAssistantApplication.class, args);
    }

    @Bean
    CommandLineRunner run(SuggestionService suggestionService) {
        return args -> {
            String suggestion = suggestionService.getSuggestion(3257331, 29);
            System.out.println(suggestion);
        };
    }
}
