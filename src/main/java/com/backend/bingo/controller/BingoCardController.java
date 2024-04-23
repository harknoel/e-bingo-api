package com.backend.bingo.controller;

import com.backend.bingo.service.BingoCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bingo")
public class BingoCardController {

    private final BingoCardService bingoCardService;

    public BingoCardController(BingoCardService bingoCardService) {
        this.bingoCardService = bingoCardService;
    }

    @GetMapping("/generate/card")
    public ResponseEntity<String> generateBingoCard() {
        String gameCode = bingoCardService.generateBingoCard();
        return ResponseEntity.ok(gameCode);
    }

    @GetMapping("/generate/{gameCode}")
    public ResponseEntity<Integer> generateRandomNumber(@PathVariable String gameCode) {
        int num = bingoCardService.generateRandomNumber(gameCode);
        return ResponseEntity.ok(num);
    }
}
