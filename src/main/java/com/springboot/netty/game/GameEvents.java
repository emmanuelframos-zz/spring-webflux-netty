package com.springboot.netty.game;

import java.util.Date;

public class GameEvents {

    private Game model;
    private Date when;

    public GameEvents(Game model, Date when) {
        this.model = model;
        this.when = when;
    }
}