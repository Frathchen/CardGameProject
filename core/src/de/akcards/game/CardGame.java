package de.akcards.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Logger;
import de.akcards.utils.CSV_To_JSON;

public class CardGame extends ApplicationAdapter {

	
	@Override
	public void create () {

        Gdx.app.log(CardGame.class.getName(),CSV_To_JSON.loadCSV("").getWriter().getWriter().toString());

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
