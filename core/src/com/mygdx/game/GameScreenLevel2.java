package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
    private TiledMapRenderer renderer;
    public static MyGame game;
    private final OrthographicCamera camera;
    private float stateTime;
    private SpriteBatch spriteBatch;
    private Jayz jayz;
    //changeScreenToLevel3
    private float changeScreenToLevel3X = 304;
    private float changeScreenToLevel3Y = 281;
    private float changeScreenToLevel3Width = 4;
    private float changeScreenToLevel3Height = 4;
    public static Rectangle changeScreenToLevel3;

    public static Timer timer;

    public static Sound carSound;

    public GameScreenLevel2(MyGame game) {
        changeScreenToLevel3 = new Rectangle(changeScreenToLevel3X, changeScreenToLevel3Y, changeScreenToLevel3Width, changeScreenToLevel3Height);
        TiledMap map = new TmxMapLoader().load("/Users/codecadet/personaldev/99problemsgame/core/assets/maps/map2.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1);
        spriteBatch = new SpriteBatch();
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
        stateTime = 0F;
        jayz = new Jayz(658, 83);
        timer = new Timer(spriteBatch);
        carSound = Gdx.audio.newSound(Gdx.files.internal("324138__fedefrede__car-door-close-engine-start.wav"));
        carSound.play();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        renderer.setView(camera);
        renderer.render();
        stateTime += Gdx.graphics.getDeltaTime();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        jayz.movement(stateTime, spriteBatch, jayz, new Rectangle());
        spriteBatch.end();

        timer.stage.draw();
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
