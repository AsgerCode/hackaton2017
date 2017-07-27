package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * Created by codecadet on 27/07/2017.
 */
public class MyGame extends Game {

    public GameScreen gameScreen;

    @Override
    public void create() {

        gameScreen = new GameScreen(this);
        setScreen(gameScreen);

    }
}
