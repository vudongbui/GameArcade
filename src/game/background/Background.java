package game.background;

import core.GameObject;
import renderer.ImageRenderer;

public class Background extends GameObject {
    public Background() {
        this.renderer = new ImageRenderer("resources/background/background.png");
        this.position.set(200, 300);
    }
}
