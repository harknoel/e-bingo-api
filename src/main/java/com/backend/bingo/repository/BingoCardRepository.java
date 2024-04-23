package com.backend.bingo.repository;

import com.backend.bingo.model.BingoCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BingoCardRepository extends JpaRepository<BingoCard, Integer> {
}
