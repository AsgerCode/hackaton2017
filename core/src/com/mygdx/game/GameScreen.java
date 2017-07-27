package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by codecadet on 27/07/2017.
 */
public class GameScreen implements Screen {

    private final MyGame game;
    private final OrthographicCamera camera;

    public GameScreen(MyGame game) {

        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 800, 400);
    }

    @Override
    public void render(float delta) {
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
