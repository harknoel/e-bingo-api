package com.backend.bingo.service;

import com.backend.bingo.model.BingoCard;
import com.backend.bingo.model.PlayerCard;
import com.backend.bingo.payload.CheckResponseDTO;
import com.backend.bingo.repository.BingoCardRepository;
import com.backend.bingo.repository.PlayerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final PlayerCardRepository playerCardRepository;
    private final BingoCardRepository bingoCardRepository;

    public CheckResponseDTO check(String playerToken) {
        CheckResponseDTO checkResponseDTO;
        Optional<PlayerCard> player = playerCardRepository.findPlayerCardByPlayerToken(playerToken);
        if (player.isEmpty()) {
            checkResponseDTO = new CheckResponseDTO(-1, null);
            return checkResponseDTO;
        }

        PlayerCard playerCard = player.get();

        Optional<BingoCard> bingo = bingoCardRepository.findByGameCode(playerCard.getGameCode());

        if (bingo.isEmpty()) {
            checkResponseDTO = new CheckResponseDTO(-1, null);
            return checkResponseDTO;
        }

        List<Integer> playerNumbers = playerCard.getPlayerNumbers();
        List<Integer> bingoNumbers = bingo.get().getDrawnNumbers();

        int groupSize = 5;
        for (int i = 0; i < playerNumbers.size(); i += groupSize) {
            List<Integer> group = playerNumbers.subList(i, i + groupSize);
            if(new HashSet<>(bingoNumbers).containsAll(group)) {
                char letter = "BINGO".charAt((i + 1) / groupSize);
                HashMap<Character, List<Integer>> map = new HashMap<>();
                map.put(letter, group);
                checkResponseDTO = new CheckResponseDTO(1, map);
                return checkResponseDTO;
            }
        }

        return new CheckResponseDTO(0, null);
    }
}
