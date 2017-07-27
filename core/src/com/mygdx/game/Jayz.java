package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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

    public static final int MOVEMENTSPEED = 1;

    public static float jayzX = 400;
    public static float jayzY = 200;

    public Jayz(float jayX, float jayzY) {

        this.jayzX = jayX;
        this.jayzY = jayzY;
    }

    public static void movement(float delta, SpriteBatch spriteBatch) {

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            jayzY += MOVEMENTSPEED;
            currentFrame = (Texture) Jayz.jayzAnimationBack.getKeyFrame(delta, true);
            spriteBatch.draw(currentFrame, Jayz.jayzX, Jayz.jayzY);
            currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_back_idle.png"));
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            jayzY -= MOVEMENTSPEED;
            currentFrame = (Texture) Jayz.jayzAnimationFront.getKeyFrame(delta, true);
            spriteBatch.draw(currentFrame, Jayz.jayzX, Jayz.jayzY);
            currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_front_idle.png"));
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            jayzX += MOVEMENTSPEED;
            currentFrame = (Texture) Jayz.jayzAnimationRight.getKeyFrame(delta, true);
            spriteBatch.draw(currentFrame, Jayz.jayzX, Jayz.jayzY);
            currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_right_idle.png"));
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            jayzX -= MOVEMENTSPEED;
            currentFrame = (Texture) Jayz.jayzAnimationLeft.getKeyFrame(delta, true);
            spriteBatch.draw(currentFrame, Jayz.jayzX, Jayz.jayzY);
            currentFrame = new Texture(Gdx.files.internal("/Users/codecadet/personaldev/99problemsgame/core/assets/jayz/jayz_left_idle.png"));
        } else {
            spriteBatch.draw(currentFrame, Jayz.jayzX, Jayz.jayzY);
            }
    }
}
