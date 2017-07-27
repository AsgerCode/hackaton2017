package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "O JOGO DO ANDRÉ PORQUE ELE É LINDO";
		config.width = 1920;
		config.height = 1080;

		new LwjglApplication(new MyGame(), config);


	}
}
