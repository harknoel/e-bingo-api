package com.backend.bingo.model;

import com.backend.bingo.util.RandomCodeGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PlayerCard {

    public PlayerCard() {
        this.playerGameCode = RandomCodeGenerator.randomCode(16);
    }

    @Id
    @GeneratedValue
    private Integer playerCardId;

    private String playerGameCode;
}
