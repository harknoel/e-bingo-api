package com.backend.bingo.repository;

import com.backend.bingo.model.PlayerCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerCardRepository extends JpaRepository<PlayerCard, Integer> {
    Optional<PlayerCard> findPlayerCardByPlayerToken(String playerToken);
}
