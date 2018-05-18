package com.springboot.netty.game;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Game {

    private String id;
    private String name;

    public Game(String id, String name) {
        this.id = id;
        this.name = name;
    }
}