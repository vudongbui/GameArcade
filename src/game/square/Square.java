package game.square;

import core.GameObject;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import utils.Utils;

public class Square extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public Square() {
        this.renderer = new ImageRenderer("resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        if(this.position.y >= 600){
            this.isAlive = false;
        }
    }

    public void getHit() {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
