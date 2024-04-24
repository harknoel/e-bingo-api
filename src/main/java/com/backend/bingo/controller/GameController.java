package com.backend.bingo.controller;

import com.backend.bingo.payload.CheckResponseDTO;
import com.backend.bingo.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/check/{playerToken}")
    public CheckResponseDTO check(@PathVariable String playerToken) {
        return gameService.check(playerToken);
    }
}
