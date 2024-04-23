package com.backend.bingo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@Entity
public class BingoCard {

    public BingoCard() {
        this.bingoNumbers = initializeNumbers();
        this.gameCode = generateGameCode();
    }

    @Id
    @GeneratedValue
    private Integer bingoCardId;

    private String gameCode;

    @ElementCollection
    private List<Integer> drawnNumbers;

    @ElementCollection
    private List<Integer> bingoNumbers;

    private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateGameCode() {
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(8); // Length of the game code

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(ALPHANUMERIC_CHARACTERS.length());
            char randomChar = ALPHANUMERIC_CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    private List<Integer> initializeNumbers() {
        return IntStream.rangeClosed(1, 75)
                .boxed()
                .collect(Collectors.toList());
    }
}
