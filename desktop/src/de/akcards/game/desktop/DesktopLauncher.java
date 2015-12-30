package de.akcards.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.akcards.game.CardGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "TestTutorial";
        config.width = 800;
        config.height = 480;
		new LwjglApplication(new CardGame(), config);
	}
}
