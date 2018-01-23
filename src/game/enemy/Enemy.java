package game.enemy;

import core.GameObject;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import utils.Utils;

public class Enemy extends GameObject implements PhysicBody {
    private Enemyshoot enemyshoot;
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/square/enemy_square_medium.png");
        this.velocity = new Vector2D();
        this.enemyshoot = new Enemyshoot();
        this.boxCollider = new BoxCollider(40,50);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.enemyshoot.run(this);
        if(this.position.y >= 600){
            this.isAlive = false;
        }
    }

    public void getHit() {
        this.isAlive = false;
    }

    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
