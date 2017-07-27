package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by codecadet on 27/07/2017.
 */
public class GameScreen implements Screen {

    private final MyGame game;
    private final OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private float stateTime;

    public GameScreen(MyGame game) {

        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);

        spriteBatch = new SpriteBatch();

        stateTime = 0F;

        Jayz jayz = new Jayz(400, 200);

        Gdx.graphics.setContinuousRendering(true);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        stateTime += Gdx.graphics.getDeltaTime();
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
            Jayz.movement(stateTime, spriteBatch);
        spriteBatch.end();
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
