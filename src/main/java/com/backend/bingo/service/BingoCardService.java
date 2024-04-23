package com.backend.bingo.service;

import com.backend.bingo.model.BingoCard;
import com.backend.bingo.repository.BingoCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BingoCardService {
    private final BingoCardRepository bingoCardRepository;

    public int generateRandomNumber(String gameCode) {
        Optional<BingoCard> optionalBingoCard = bingoCardRepository.findByGameCode(gameCode);
        if(optionalBingoCard.isEmpty()) {
            return -1;
        }

        BingoCard bingoCard = optionalBingoCard.get();
        List<Integer> bingoNumbers = bingoCard.getBingoNumbers();
        if(bingoNumbers.isEmpty()) {
            return -1;
        }

        // Generate a random index to select a number from the bingoNumbers list
        Random random = new Random();
        int randomIndex = random.nextInt(bingoNumbers.size());

        Integer randomNumber = bingoNumbers.get(randomIndex);

        // Move the selected number to the drawnNumbers list
        List<Integer> drawnNumbers = bingoCard.getDrawnNumbers();
        if (drawnNumbers == null) {
            drawnNumbers = new ArrayList<>();
        }
        drawnNumbers.add(randomNumber);

        // Remove the selected number from the bingoNumbers list
        bingoNumbers.remove(randomIndex);

        // Update the BingoCard object
        bingoCard.setDrawnNumbers(drawnNumbers);
        bingoCardRepository.save(bingoCard);

        return randomNumber;
    }

    public String generateBingoCard() {
        BingoCard bingoCard = new BingoCard();
        bingoCardRepository.save(bingoCard);
        return bingoCard.getGameCode();
    }
}
