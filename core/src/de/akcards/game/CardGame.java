package de.akcards.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Logger;
import de.akcards.database.CardCreator;
import de.akcards.database.CouchDBConnector;
import de.akcards.game.menus.InGameScreen;
import de.akcards.game.menus.MainMenu;
import de.akcards.utils.CSV_To_JSON;

public class CardGame extends Game {

	public BitmapFont font;
	public SpriteBatch batch;

	@Override
	public void create () {

        Json testJSON = CSV_To_JSON.loadCSV("");
        if (testJSON != null){
            Gdx.app.log(CardGame.class.getName(),testJSON.toString());
        }

        batch = new SpriteBatch();
        //Use LibGDX's default Arial font.
        font = new BitmapFont();
        this.setScreen(new MainMenu(this));

	}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

	@Override
	public void render () {
		super.render();
	}


}
