package com.backend.bingo.model;

import com.backend.bingo.util.NumberInitializer;
import com.backend.bingo.util.RandomCodeGenerator;
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
        this.bingoNumbers = NumberInitializer.initializeNumbers(1, 75);
        this.gameCode = RandomCodeGenerator.randomCode(8);
    }

    @Id
    @GeneratedValue
    private Integer bingoCardId;

    private String gameCode;

    @ElementCollection
    private List<Integer> drawnNumbers;

    @ElementCollection
    private List<Integer> bingoNumbers;
}
