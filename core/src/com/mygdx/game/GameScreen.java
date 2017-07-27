package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by codecadet on 27/07/2017.
 */
public class GameScreen implements Screen {

    private final MyGame game;
    private final OrthographicCamera camera;

    //textures
    private Texture texture;
    private Texture textureNextLevel;

    private Texture currentTexture;

    private Texture mock;

    private SpriteBatch sprite;


    private final int screenSizeWidth = 800;
    private final int screenSizeHeigth = 400;

    public GameScreen(MyGame game) {
        this.texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        this.textureNextLevel = new Texture(Gdx.files.internal("jayz.jpg"));
        this.currentTexture = texture;

        this.mock = new Texture(Gdx.files.internal("Pikachu_sprite.png"));

        this.sprite = new SpriteBatch();
        this.game = game;
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(true, 800, 400);
        //sprite.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

       // camera.update();
        updateScreen();

        sprite.begin();
       // sprite.draw(currentTexture,0,0 , screenSizeWidth,screenSizeHeigth);
        placeSprite(sprite,mock,30,30);
        sprite.end();
    }

    private void updateScreen() {
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            textureSwapper(textureNextLevel);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.N)){
            textureSwapper(texture);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)){
            placeSprite(sprite,mock,);
        }

    }

    private void placeSprite(SpriteBatch sprite,Texture texture, int x, int y){
        sprite.draw(texture,x,y);
    }



    private void textureSwapper(Texture texture){
        this.currentTexture = texture;
    }


    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        sprite.dispose();
        texture.dispose();
        textureNextLevel.dispose();
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
