package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by codecadet on 28/07/2017.
 */
public class MainMenu implements Screen {


    private TiledMapRenderer renderer;
    public  MyGame game;
    private final OrthographicCamera camera;
    private float stateTime;
    private SpriteBatch spriteBatch;
    private Texture mainScreen;
    private Sound sound;

    public MainMenu(MyGame game) {
        spriteBatch = new SpriteBatch();
        mainScreen = new Texture(Gdx.files.internal("main_menu.png"));
        this.game = game;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false,800,400);
        sound = Gdx.audio.newSound(Gdx.files.internal("01 99 Problems.mp3"));

    }
    @Override
    public void show() {
        sound.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        spriteBatch.draw(mainScreen,0,0);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            sound.setVolume(0,0.2f);
            game.setScreen(new GameScreen(game));
        }
        spriteBatch.end();
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
