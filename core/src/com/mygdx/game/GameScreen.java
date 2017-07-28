package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
    public static MyGame game;
    private final OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private float stateTime;

    //outerwall
    private float outerWallX = 390;
    private float outerwallY = 47;
    private float outerWallWidth = 14;
    private float outerWallHeight = 356;


    //piano
    private float pianoX = 270;
    private float pianoY = 250;
    private float pianoWidth = 65;
    private float pianoHeight = 65;

    //inner wall right
    private float roomWallRightX = 200;
    private float roomWallRightY = 105;
    private float roomWallRightWidth = 16;
    private float roomWallRightHeight = 299;

    //inner wall down
    private float roomWallDownX = 40;
    private float roomWallDownY = 105;
    private float roomWallDownWidth = 173;
    private float roomWallDownHeight = 16;

    //bed
    private float bedX = 45;
    private float bedY = 280;
    private float bedWidth = 65;
    private float bedHeight = 70;

    //closet
    private float closetX = 145;
    private float closetY = 310;
    private float closeWidth = 40;
    private float closeHeight = 45;

    //upWall
    private float upWallX = -20;
    private float upWallY = 360;
    private float upWallWidth = 400;
    private float upWallHeight = 30;

    //door
    private float doorX = 390;
    private float doorY = 0;
    private float doorWidth = 14;
    private float doorHeight = 356;

    //rightsofa
    private float rightSofaX = 350;
    private float rightSofaY = 140;
    private float rightSofaWidth = 30;
    private float rightSofaHeight = 75;

    //changeScreenRectangle
    private float changeScreenX = 800;
    private float changeScreenY = 113 ;
    private float changeScreenWidth = 1 ;
    private float changeScreenHeight = 1 ;


    public static Rectangle wallRectangle;
    public static Rectangle piano;
    public static Rectangle roomWallRight;
    public static Rectangle roomWallDown;
    public static Rectangle bed;
    public static Rectangle closet;
    public static Rectangle upWall;
    public static Rectangle door;
    public static Rectangle rightSofa;
    public static Rectangle changeScreen;

    private Jayz jayz;

    public static Timer timer;

    public static SpriteBatch spriteBHint;
    public static Texture hint;
    public static Texture foundKeys;
    public static Texture carInstruction;

    //public static Label labelText;

    public GameScreen(MyGame game) {

        Gdx.graphics.setContinuousRendering(true);

        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);

        spriteBHint = new SpriteBatch();
        hint = new Texture(Gdx.files.internal("RULES.png"));

        foundKeys = new Texture(Gdx.files.internal("foun_keys.png"));

        carInstruction = new Texture(Gdx.files.internal("get_in_car.png"));

        spriteBatch = new SpriteBatch();

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
        door = new Rectangle(doorX, doorY, doorWidth, doorHeight);
        rightSofa = new Rectangle(rightSofaX, rightSofaY, rightSofaWidth, rightSofaHeight);
        changeScreen = new Rectangle(changeScreenX,changeScreenY,changeScreenWidth,changeScreenHeight);


        timer = new Timer(spriteBatch);
       // labelText = new Label("HINT: Dress yourself!", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        jayz = new Jayz(73, 209);
    }


    @Override
    public void render(float delta) {

        if(timer.isTimeUp()){

        }

        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        renderer.setView(camera);
        renderer.render();

        stateTime += Gdx.graphics.getDeltaTime();
        spriteBatch.setProjectionMatrix(camera.combined);
       // spriteBHint.setProjectionMatrix(camera.combined);


        spriteBatch.begin();
        jayz.movement(stateTime, spriteBatch, jayz, wallRectangle);
        timer.update(delta);
        spriteBatch.end();

        spriteBHint.begin();
        spriteBHint.draw(hint,1040,0);
        spriteBHint.end();

        timer.stage.draw();

        System.out.println(jayz.isDressed);
        System.out.println(closetX);
        System.out.println(closetY);
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
