package aritzh.libgdx.game1.core.screens;

import aritzh.libgdx.game1.core.Game;
import aritzh.libgdx.game1.core.util.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.google.common.base.Function;
import com.sun.istack.internal.Nullable;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GameScreen extends MyScreen {

    private static final String TAG = "LGDXG1";
    private final Game game;
    private final Renderer renderer;

    public GameScreen(final Game game) {
        super(new OrthographicCamera());
        this.game = game;
        this.renderer = this.game.proxy.getRenderer(this.game);

        final Rectangle rectangle = new Rectangle((int) this.game.width - 64 - Renderer.MARGIN, (int) this.game.height - 64 - Renderer.MARGIN, 64, 64);
        final Function<Integer, Boolean> function = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(@Nullable Integer button) {
                Gdx.app.log(TAG, "Yeah!");
                return Boolean.TRUE;
            }
        };
        this.regions.add(new ClickableRegion(rectangle, function));
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();

        this.renderer.renderAll(delta, true);

        this.game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        this.camera.setToOrtho(false, width, height);
        this.game.width = width;
        this.game.height = height;
    }

    @Override
    public void show() {
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
