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

    @GetMapping("/generate/{bingoId}")
    public ResponseEntity<Integer> generateRandomNumber(@PathVariable Integer bingoId) {
        int num = bingoCardService.generateRandomNumber(bingoId);
        return ResponseEntity.ok(num);
    }
}
