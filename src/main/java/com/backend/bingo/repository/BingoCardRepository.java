package com.backend.bingo.repository;

import com.backend.bingo.model.BingoCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BingoCardRepository extends JpaRepository<BingoCard, Integer> {
    Optional<BingoCard> findByGameCode(String gameCode);
}
