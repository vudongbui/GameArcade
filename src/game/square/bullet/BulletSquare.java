package game.square.bullet;

import core.GameObject;
import core.Vector2D;
import renderer.ImageRenderer;
import utils.Utils;

public class BulletSquare extends GameObject {
    public Vector2D velocity;

    public BulletSquare() {
        this.renderer = new ImageRenderer("resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
