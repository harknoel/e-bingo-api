package com.backend.bingo.service;

import com.backend.bingo.model.PlayerCard;
import com.backend.bingo.payload.PlayerCardResponseDTO;
import com.backend.bingo.repository.PlayerCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerCardService {

    private final PlayerCardRepository playerCardRepository;

    public PlayerCardResponseDTO generateCard(String gameCode) {
        PlayerCard playerCard = new PlayerCard(gameCode);
        playerCardRepository.save(playerCard);
        return new PlayerCardResponseDTO(playerCard.getPlayerToken(), playerCard.getPlayerNumbers());
    }
}
