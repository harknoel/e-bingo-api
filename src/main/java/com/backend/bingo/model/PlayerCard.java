package com.backend.bingo.model;

import com.backend.bingo.util.RandomCodeGenerator;
import com.backend.bingo.util.RandomNumberInitializer;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class PlayerCard {

    public PlayerCard(String gameCode) {
        this.playerToken = RandomCodeGenerator.randomCode(16);
        this.playerNumbers = RandomNumberInitializer.generateRandomNumbers(1, 75, 25);
        this.gameCode = gameCode;
    }

    @Id
    @GeneratedValue
    private Integer playerCardId;

    private String playerToken;

    private String gameCode;

    @ElementCollection
    private List<Integer> playerNumbers;

}
