package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;

import static com.mygdx.game.GameScreen.changeScreen;

/**
 * Created by codecadet on 28/07/2017.
 */
public class CollisionDetector {

    public void collisionDetector(Jayz jayz, Rectangle toSupervise) {

        if (Jayz.currentLevel == 1
                && toSupervise == changeScreen
                && Jayz.hitBox.getX() < changeScreen.getX()
                && Jayz.hitBox.getX() > changeScreen.getX() - 100
                && Jayz.hitBox.getY() > changeScreen.getY() - 50
                && Jayz.hitBox.getY() < changeScreen.getY() + 50) {
            GameScreen.timer.addScore(100);
            Jayz.currentLevel = 2;
            GameScreen.game.setScreen(new GameScreenLevel2(GameScreen.game));
        }

        if (jayz.hitBox.overlaps(toSupervise) && jayz.keyPressed.equals("W") || jayz.hitBox.getY() > 380) {
            jayz.jayzY -= jayz.MOVEMENTSPEED;
            jayz.hitBox.setY(jayz.hitBox.getY() - jayz.MOVEMENTSPEED);

        } else if (jayz.hitBox.overlaps(toSupervise) && jayz.keyPressed.equals("S") || jayz.hitBox.getY() < 0) {
            jayz.jayzY += jayz.MOVEMENTSPEED;
            jayz.hitBox.setY(jayz.hitBox.getY() + jayz.MOVEMENTSPEED);

        } else if (jayz.hitBox.overlaps(toSupervise) && jayz.keyPressed.equals("A") || jayz.hitBox.getX() < -10) {
            jayz.jayzX += jayz.MOVEMENTSPEED;
            jayz.hitBox.setX(jayz.hitBox.getX() + jayz.MOVEMENTSPEED);

        } else if (jayz.hitBox.overlaps(toSupervise) && jayz.keyPressed.equals("D") || jayz.hitBox.getX() > 775) {
            jayz.jayzX -= jayz.MOVEMENTSPEED;
            jayz.hitBox.setX(jayz.hitBox.getX() - jayz.MOVEMENTSPEED);
        }


    }
}
