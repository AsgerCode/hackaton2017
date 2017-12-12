package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 28/07/17.
 */
public class GameScreenLevel2 implements Screen {
    public static TiledMap map;
    private Texture background;
    public static MyGame game;
    private final OrthographicCamera camera;
    private final SpriteBatch batch;
    private BitmapFont font;

    public static Timer timer;

    public static Sound carSound;

    public GameScreenLevel2(MyGame game) {
        background = new Texture(Gdx.files.internal("maps/950x350-black-solid-color-background.jpg"));
        this.game = game;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
        carSound = Gdx.audio.newSound(Gdx.files.internal("324138__fedefrede__car-door-close-engine-start.wav"));
        carSound.play();
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        font = new BitmapFont();
        font.getData().setScale(3);

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        font.draw(batch, "This was just a taster and will never be finished", 250, 500);
        font.draw(batch, "github.com/AsgerCode", 475, 300);
        font.draw(batch, "github.com/BigMakak", 475, 250);
        font.draw(batch, "github.com/ritafialho", 475, 200);
        font.draw(batch, "github.com/salvadorDALU", 475, 150);
        batch.end();
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

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
