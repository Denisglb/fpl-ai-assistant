package com.example.fpl_assitant.db;

import com.example.fpl_assitant.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
