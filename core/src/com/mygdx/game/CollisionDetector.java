package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

import static com.mygdx.game.GameScreen.map;

/**
 * Created by codecadet on 28/07/2017.
 */
public class CollisionDetector {

    public void collisionDetector(Jayz jayz, Rectangle toSupervise) {

    /*    System.out.println("JayzHITBOX-X"+jayz.hitBox.getX());
        System.out.println("JayzHITBOX-Y"+jayz.hitBox.getY());

        System.out.println("toSupervise-X"+toSupervise.getX());
        System.out.println("toSuperVise-Y"+toSupervise.getY());
*/

        if (jayz.hitBox.overlaps(toSupervise)) {
            jayz.jayzY -= jayz.MOVEMENTSPEED;
            jayz.jayzX -= jayz.MOVEMENTSPEED;
            jayz.hitBox.setX(jayz.hitBox.getX() - jayz.MOVEMENTSPEED);
            jayz.hitBox.setY(jayz.hitBox.getY() - jayz.MOVEMENTSPEED);

        }

/*
        System.out.println("JayzHITBOX-X"+jayz.hitBox.getX());
        System.out.println("JayzHITBOX-Y"+jayz.hitBox.getY());

        System.out.println("toSupervise-X"+toSupervise.getX());
        System.out.println("toSuperVise-Y"+toSupervise.getY());
*/
    }
}
