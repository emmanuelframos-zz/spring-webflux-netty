package com.springboot.netty.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GameRestController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games/{gameId}")
    public Mono<Game> findById(@PathVariable String gameId) {
        return gameService.findById(gameId);
    }

    @GetMapping("/games")
    public Flux<Game> finadAll() {
        return gameService.findAll();
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/games/{gameId}/events")
    public Flux<GameEvents> events(@PathVariable String gameId) {
        return gameService.events(gameId);
    }

}
