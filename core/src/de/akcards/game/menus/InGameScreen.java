package de.akcards.game.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import de.akcards.game.CardGame;

/**
 * Created by Frath on 18.03.2016.
 */
public class InGameScreen implements Screen {
    final CardGame game;
    OrthographicCamera camera;
    Rectangle bucketRect;
    SpriteBatch bucket;
    Texture cardBackImage;


    public InGameScreen(final CardGame gam) {
        this.game = gam;
        camera = new OrthographicCamera();
        bucketRect = new Rectangle(0,0,100,100);
        bucket = new SpriteBatch();
        cardBackImage = new Texture(Gdx.files.internal("AK_Backward.png"));
    }

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        game.batch.begin();
        game.font.draw(game.batch, "AK (beta) ", 0, 480);
        game.batch.end();

        // process user input


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            bucketRect.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            bucketRect.x += 200 * Gdx.graphics.getDeltaTime();

        // make sure the bucket stays within the screen bounds
        if (bucketRect.x < 0)
            bucketRect.x = 0;
        if (bucketRect.x > 800 - 64)
            bucketRect.x = 800 - 64;

        bucket.setProjectionMatrix(camera.combined);
        bucket.begin();
        for (int i = 0; i < 5; i++) {
            bucket.draw(cardBackImage, bucketRect.x + i * 50, bucketRect.y);
        }

        bucket.end();

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown

    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}
