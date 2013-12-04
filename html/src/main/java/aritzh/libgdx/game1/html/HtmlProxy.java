package aritzh.libgdx.game1.html;

import aritzh.libgdx.game1.core.Proxy;
import aritzh.libgdx.game1.core.input.InputHandler;
import aritzh.libgdx.game1.core.input.KeyboardInput;
import aritzh.libgdx.game1.core.input.PlatformInput;

/**
 * @author Aritz Lopez
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class HtmlProxy implements Proxy {

    @Override
    public boolean vsync() {
        return true;
    }

    @Override
    public PlatformInput createPlatformInput(InputHandler handler) {
        return new KeyboardInput(handler);
    }
}
