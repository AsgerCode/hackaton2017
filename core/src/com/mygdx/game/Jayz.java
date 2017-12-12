package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 27/07/2017.
 */
public class Jayz {

    public static final Texture[] jayzBack = {new Texture(Gdx.files.internal("jayz/jayz_back_rightfoot.png")), new Texture(Gdx.files.internal("jayz/jayz_back_walking_leftfoot.png"))};
    public static final Texture[] jayzFront = {new Texture(Gdx.files.internal("jayz/jayz_front_leftfoot.png")), new Texture(Gdx.files.internal("jayz/jayz_front_rightfoot.png"))};
    public static final Texture[] jayzRight = {new Texture(Gdx.files.internal("jayz/jayz_rigth_rigthfoot.png")), new Texture(Gdx.files.internal("jayz/jayz_right_leftfoot.png"))};
    public static final Texture[] jayzLeft = {new Texture(Gdx.files.internal("jayz/jayz_left_rightfoot.png")), new Texture(Gdx.files.internal("jayz/jayz_left_leftfoot.png"))};

    public static final Texture[] nakedJayzBack = {new Texture(Gdx.files.internal("jayz/naked_jayz_back_leftfoot.png")), new Texture(Gdx.files.internal("jayz/naked_jayz_back_rightfoot.png"))};
    public static final Texture[] nakedJayzFront = {new Texture(Gdx.files.internal("jayz/naked_jayz_front_leftfoot.png")), new Texture(Gdx.files.internal("jayz/naked_jayz_front_rightfoot.png"))};
    public static final Texture[] nakedJayzRight = {new Texture(Gdx.files.internal("jayz/naked_jayz_right_leftfoot_.png")), new Texture(Gdx.files.internal("jayz/naked_jayz_right_rightfoot_.png"))};
    public static final Texture[] nakedJayzLeft = {new Texture(Gdx.files.internal("jayz/naked_jayz_left_leftfoot_.png")), new Texture(Gdx.files.internal("jayz/naked_jayz_left_rightfoot_.png"))};

    public static final Animation jayzAnimationBack = new Animation(0.2F, jayzBack);
    public static final Animation jayzAnimationFront = new Animation(0.2F, jayzFront);
    public static final Animation jayzAnimationRight = new Animation(0.2F, jayzRight);
    public static final Animation jayzAnimationLeft = new Animation(0.2F, jayzLeft);

    public static final Animation nakedJayzAnimationBack = new Animation(0.2F, nakedJayzBack);
    public static final Animation nakedJayzAnimationFront = new Animation(0.2F, nakedJayzFront);
    public static final Animation nakedJayzAnimationRight = new Animation(0.2F, nakedJayzRight);
    public static final Animation nakedJayzAnimationLeft = new Animation(0.2F, nakedJayzLeft);

    public static Texture currentFrame = new Texture(Gdx.files.internal("jayz/naked_jayz_front_idkle.png"));

    public static final int MOVEMENTSPEED = 2;

    public static float jayzX = 400;
    public static float jayzY = 200;

    public static String keyPressed = "";

    private static float sizeX = 37;
    private static float sizeY = 37;

    public static Rectangle hitBox;
    private static CollisionDetector collisionDetector;

    public static boolean isDressed = false;
    public static boolean hasKey = false;

    public static int currentLevel = 1;

    public static int count1;
    public static int count2;
    public static int count3;

    public Jayz(float jayzX, float jayzY) {

        this.jayzX = jayzX;
        this.jayzY = jayzY;

        collisionDetector = new CollisionDetector();

        hitBox = new Rectangle(jayzX, jayzY, 15, 15);

        count3 = 0;
    }

    public static void movement(float delta, SpriteBatch spriteBatch, Jayz jayz, Rectangle toSupervise) {

        if (!jayz.isDressed) {

            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                jayz.jayzY += MOVEMENTSPEED;
                hitBox.setY(hitBox.getY() + MOVEMENTSPEED);
                currentFrame = (Texture) jayz.nakedJayzAnimationBack.getKeyFrame(delta, true);
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
                keyPressed = "W";
                currentFrame = new Texture(Gdx.files.internal("jayz/naked_jayz_back_idle.png"));
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                jayzY -= MOVEMENTSPEED;
                hitBox.setY(hitBox.getY() - MOVEMENTSPEED);
                currentFrame = (Texture) jayz.nakedJayzAnimationFront.getKeyFrame(delta, true);
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
                keyPressed = "S";
                currentFrame = new Texture(Gdx.files.internal("jayz/naked_jayz_front_idkle.png"));
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                jayzX += MOVEMENTSPEED;
                hitBox.setX(hitBox.getX() + MOVEMENTSPEED);
                currentFrame = (Texture) jayz.nakedJayzAnimationRight.getKeyFrame(delta, true);
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
                keyPressed = "D";
                currentFrame = new Texture(Gdx.files.internal("jayz/naked_jayz_right_idle.png"));
            } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                jayzX -= MOVEMENTSPEED;
                hitBox.setX(hitBox.getX() - MOVEMENTSPEED);
                currentFrame = (Texture) jayz.nakedJayzAnimationLeft.getKeyFrame(delta, true);
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
                keyPressed = "A";
                currentFrame = new Texture(Gdx.files.internal("jayz/naked_jayz_left_idlke.png"));
            } else {
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
            }

        } else {

            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                jayz.jayzY += MOVEMENTSPEED;
                hitBox.setY(hitBox.getY() + MOVEMENTSPEED);
                currentFrame = (Texture) jayz.jayzAnimationBack.getKeyFrame(delta, true);
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
                keyPressed = "W";
                currentFrame = new Texture(Gdx.files.internal("jayz/jayz_back_idle.png"));
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                jayzY -= MOVEMENTSPEED;
                hitBox.setY(hitBox.getY() - MOVEMENTSPEED);
                currentFrame = (Texture) jayz.jayzAnimationFront.getKeyFrame(delta, true);
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
                keyPressed = "S";
                currentFrame = new Texture(Gdx.files.internal("jayz/jayz_front_idle.png"));
            } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                jayzX += MOVEMENTSPEED;
                hitBox.setX(hitBox.getX() + MOVEMENTSPEED);
                currentFrame = (Texture) jayz.jayzAnimationRight.getKeyFrame(delta, true);
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
                keyPressed = "D";
                currentFrame = new Texture(Gdx.files.internal("jayz/jayz_right_idle.png"));
            } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                jayzX -= MOVEMENTSPEED;
                hitBox.setX(hitBox.getX() - MOVEMENTSPEED);
                currentFrame = (Texture) jayz.jayzAnimationLeft.getKeyFrame(delta, true);
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
                keyPressed = "A";
                currentFrame = new Texture(Gdx.files.internal("jayz/jayz_left_idle.png"));
            } else {
                spriteBatch.draw(currentFrame, jayz.jayzX, jayz.jayzY, sizeX, sizeY);
            }
        }

        if (jayz.hitBox.getY() > GameScreen.closet.getY() - 25
                && jayz.hitBox.getY() < GameScreen.closet.getY() + 25
                && jayz.hitBox.getX() > GameScreen.closet.getX() - 10
                && jayz.hitBox.getX() < GameScreen.closet.getX() + 10
                && Gdx.input.isKeyPressed(Input.Keys.E)) {
            if(count1 == 0) {
                GameScreen.timer.addScore(50);
                ++count1;
            }
            jayz.isDressed = true;
            currentFrame = new Texture(Gdx.files.internal("jayz/jayz_back_idle.png"));
        }

        if (jayz.hitBox.getX() > GameScreen.rightSofa.getX() - 20
                && jayz.hitBox.getX() < GameScreen.rightSofa.getX()
                && jayz.hitBox.getY() < GameScreen.rightSofa.getY() + 30
                && jayz.hitBox.getY() > GameScreen.rightSofa.getY() - 30
                && Gdx.input.isKeyPressed(Input.Keys.E)){

            if(count2 == 0) {
                GameScreen.timer.addScore(50);
                ++count2;
            }
            hasKey = true;
        }

        if(currentLevel == 1) {
            collisionDetector.collisionDetector(jayz, toSupervise);
            collisionDetector.collisionDetector(jayz, GameScreen.piano);
            collisionDetector.collisionDetector(jayz, GameScreen.roomWallDown);
            collisionDetector.collisionDetector(jayz, GameScreen.roomWallRight);
            collisionDetector.collisionDetector(jayz, GameScreen.bed);
            collisionDetector.collisionDetector(jayz, GameScreen.closet);
            collisionDetector.collisionDetector(jayz, GameScreen.upWall);
            collisionDetector.collisionDetector(jayz, GameScreen.rightSofa);
            collisionDetector.collisionDetector(jayz, GameScreen.changeScreen);
        }


        if (!jayz.isDressed || !jayz.hasKey) {
            collisionDetector.collisionDetector(jayz, GameScreen.door);
            if (count3 == 0){
                count3 += 1;
                GameScreen.foundKeys.dispose();
            }
        }

        if (jayz.isDressed) {

        }
    }
}
