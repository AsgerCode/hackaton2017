package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ai.utils.Collision;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 27/07/2017.
 */
public class Jayz {

    public static final Texture[] jayzBack = {new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_back_rightfoot.png")), new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_back_walking_leftfoot.png"))};
    public static final Texture[] jayzFront = {new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_front_leftfoot.png")), new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_front_rightfoot.png"))};
    public static final Texture[] jayzRight = {new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_rigth_rigthfoot.png")), new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_right_leftfoot.png"))};
    public static final Texture[] jayzLeft = {new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_left_rightfoot.png")), new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_left_leftfoot.png"))};

    public static final Animation jayzAnimationBack = new Animation(0.2F, jayzBack);
    public static final Animation jayzAnimationFront = new Animation(0.2F, jayzFront);
    public static final Animation jayzAnimationRight = new Animation(0.2F, jayzRight);
    public static final Animation jayzAnimationLeft = new Animation(0.2F, jayzLeft);

    public static Texture currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_front_idle.png"));

    public static final int MOVEMENTSPEED = 3;

    public static float jayzX = 400;
    public static float jayzY = 200;
    private static float sizeX = 37;
    private static float sizeY = 37;

    public static Rectangle hitBox;
    private static CollisionDetector collisionDetector;

    public Jayz(float jayzX, float jayzY) {

        this.jayzX = jayzX;
        this.jayzY = jayzY;

        collisionDetector = new CollisionDetector();

        hitBox = new Rectangle(jayzX, jayzY, 15, 15);

        System.out.println();
    }

    public static void movement(float delta, SpriteBatch spriteBatch, Jayz jayz, Rectangle toSupervise) {

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            jayz.jayzY += MOVEMENTSPEED;
            hitBox.setY(hitBox.getY() + MOVEMENTSPEED);
            currentFrame = (Texture) jayz.jayzAnimationBack.getKeyFrame(delta, true);
            spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY,sizeX,sizeY);
            currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_back_idle.png"));
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            jayzY -= MOVEMENTSPEED;
            hitBox.setY(hitBox.getY() - MOVEMENTSPEED);
            currentFrame = (Texture) jayz.jayzAnimationFront.getKeyFrame(delta, true);
            spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY,sizeX,sizeY);
            currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_front_idle.png"));
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            jayzX += MOVEMENTSPEED;
            hitBox.setX(hitBox.getX() + MOVEMENTSPEED);
            currentFrame = (Texture) jayz.jayzAnimationRight.getKeyFrame(delta, true);
            spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY,sizeX,sizeY);
            currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_right_idle.png"));
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            jayzX -= MOVEMENTSPEED;
            hitBox.setX(hitBox.getX() - MOVEMENTSPEED);
            currentFrame = (Texture) jayz.jayzAnimationLeft.getKeyFrame(delta, true);
            spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY,sizeX,sizeY);
            currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_left_idle.png"));
        } else {
            spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY,sizeX,sizeY);
        }

        collisionDetector.collisionDetector(jayz, toSupervise);
        collisionDetector.collisionDetector(jayz,GameScreen.piano);
        collisionDetector.collisionDetector(jayz, GameScreen.roomWallDown);
        collisionDetector.collisionDetector(jayz, GameScreen.roomWallRight);
        collisionDetector.collisionDetector(jayz,GameScreen.bed);
        collisionDetector.collisionDetector(jayz,GameScreen.closet);
        collisionDetector.collisionDetector(jayz,GameScreen.upWall);

        System.out.println("Jayz X: "+jayz.hitBox.getX());
        System.out.println("Jayz Y: "+jayz.hitBox.getY());
    }
}
