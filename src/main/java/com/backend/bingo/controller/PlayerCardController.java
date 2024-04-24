package com.backend.bingo.controller;

import com.backend.bingo.payload.PlayerCardResponseDTO;
import com.backend.bingo.service.PlayerCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerCardController {

    private final PlayerCardService playerCardService;

    public PlayerCardController(PlayerCardService playerCardService) {
        this.playerCardService = playerCardService;
    }

    @GetMapping("/generate/{gameCode}")
    public PlayerCardResponseDTO generateCard(@PathVariable String gameCode) {
        return playerCardService.generateCard(gameCode);
    }
}
