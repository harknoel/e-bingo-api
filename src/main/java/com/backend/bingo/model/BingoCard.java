package com.backend.bingo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@Entity
public class BingoCard {
    @Id
    @GeneratedValue
    private Integer bingoCardId;

    @ElementCollection
    private List<Integer> drawnNumbers;

    @ElementCollection
    private List<Integer> bingoNumbers;

    public BingoCard() {
        this.bingoNumbers = initializeNumbers();
    }

    private List<Integer> initializeNumbers() {
        return IntStream.rangeClosed(1, 75)
                .boxed()
                .collect(Collectors.toList());
    }
}
