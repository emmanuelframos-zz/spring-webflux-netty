package com.springboot.netty.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class GameDataRunner implements CommandLineRunner {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public void run(String... args){
        gameRepository
            .deleteAll()
            .thenMany(
                Flux.just("Dota 2", "PUBG", "League of Legends", "Fortinite", "Counter Strike GO")
                    .map(model -> new Game(UUID.randomUUID().toString(), model))
                    .flatMap(gameRepository::save)
            ).subscribe(System.out::println);
    }
}
