package com.backend.bingo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlayerCardResponseDTO {
    private String player_token;
    private List<Integer> card;
}
