package com.springboot.netty.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Mono<Game> findById(String gameId) {
        return gameRepository.findById(gameId);
    }

    public Flux<Game> findAll () {
        return gameRepository.findAll();
    }

    public Flux<GameEvents> events(String gameId) {
        return findById(gameId).flatMapMany(game -> {
            Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));

            Flux<GameEvents> events = Flux.fromStream(
                Stream.generate(() -> new GameEvents(game, new Date()))
            );

            return Flux.zip(interval, events)
                    .map(Tuple2::getT2);
        });


    }
}