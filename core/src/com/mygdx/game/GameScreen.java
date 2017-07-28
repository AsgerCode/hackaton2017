package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 27/07/2017.
 */
public class GameScreen implements Screen {

    public static TiledMap map;
    private TiledMapRenderer renderer;
    private final MyGame game;
    private final OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private float stateTime;

    //outerwall
    private float outerWallX = 390;
    private float outerwallY = 47;//-4
    private float outerWallWidth = 14;
    private float outerWallHeight = 356;


    //piano
    private float pianoX = 270;
    private float pianoY = 250;
    private float pianoWidth = 65;
    private float pianoHeight = 65;

    //inner wall right
    private float roomWallRightX = 195;
    private float roomWallRightY = 100;
    private float roomWallRightWidth = 16;
    private float roomWallRightHeight = 299;

    //inner wall down
    private float roomWallDownX = 40;
    private float roomWallDownY = 100;
    private float roomWallDownWidth = 173;
    private float roomWallDownHeight = 16;

    //bed
    private float bedX = 45;
    private float bedY = 270;
    private float bedWidth = 50;
    private float bedHeight = 70;

    //closet
    private float closetX = 145;
    private float closetY = 310;
    private float closeWidth = 25;
    private float closeHeight = 45;

    //upWall
    private float upWallX = -20;
    private float upWallY = 360;
    private float upWallWidth = 400;
    private float upWallHeight = 30;


    public static Rectangle wallRectangle;
    public static Rectangle piano;
    public static Rectangle roomWallRight;
    public static Rectangle roomWallDown;

    public static Rectangle bed;
    public static Rectangle closet;
    public static Rectangle upWall;

    private Jayz jayz;

    public GameScreen(MyGame game) {

        Gdx.graphics.setContinuousRendering(true);

        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);

        spriteBatch = new SpriteBatch();

        // TmxMapLoader.Parameters parameters = new TmxMapLoader.Parameters();
        // parameters.flipY = false;

        TiledMap map = new TmxMapLoader().load("/Users/codecadet/personaldev/99problemsgame/core/assets/maps/level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1);

        stateTime = 0F;

        wallRectangle = new Rectangle(outerWallX, outerwallY, outerWallWidth, outerWallHeight);
        piano = new Rectangle(pianoX, pianoY, pianoWidth, pianoHeight);
        roomWallRight = new Rectangle(roomWallRightX, roomWallRightY, roomWallRightWidth, roomWallRightHeight);
        roomWallDown = new Rectangle(roomWallDownX, roomWallDownY, roomWallDownWidth, roomWallDownHeight);
        bed = new Rectangle(bedX, bedY, bedWidth, bedHeight);
        closet = new Rectangle(closetX, closetY, closeWidth, closeHeight);
        upWall = new Rectangle(upWallX, upWallY, upWallWidth, upWallHeight);


        jayz = new Jayz(100, 20);

        System.out.println("ORiGIN WALLRECTANGLE - X: " + wallRectangle.getX());
        System.out.println("ORIGIN WALLRECTANGLE - Y: " + wallRectangle.getY());
        System.out.println("Jayz X: " + jayz.hitBox.getX());
        System.out.println("Jayz Y: " + jayz.hitBox.getY());


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
        jayz.movement(stateTime, spriteBatch, jayz, wallRectangle);
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
