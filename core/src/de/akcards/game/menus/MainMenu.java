package de.akcards.game.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import de.akcards.game.CardGame;

/**
 * Created by Frath on 18.03.2016.
 */
public class MainMenu implements Screen {

    final CardGame GAME;

    OrthographicCamera camera;
    
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        GAME.batch.setProjectionMatrix(camera.combined);

        GAME.batch.begin();
        GAME.font.draw(GAME.batch, "Welcome to AK!!! ", 100, 150);
        GAME.font.draw(GAME.batch, "START!", 100, 100);
        GAME.batch.end();

        if (Gdx.input.isTouched()) {
            GAME.setScreen(new InGameScreen(GAME));
            dispose();
        }
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public MainMenu(final CardGame currentGame) {


        GAME = currentGame;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }
}
