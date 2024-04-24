package com.backend.bingo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class CheckResponseDTO {
    private int winner;
    private HashMap<Character, List<Integer>> numbers;
}
