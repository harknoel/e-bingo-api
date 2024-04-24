package com.backend.bingo.repository;

import com.backend.bingo.model.PlayerCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerCardRepository extends JpaRepository<PlayerCard, Integer> {
}
