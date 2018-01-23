package game.enemy.bullet;

import core.GameObject;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import utils.Utils;

public class BulletEnemy extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private HitPlayer hitPlayer;

    public BulletEnemy() {
        this.renderer = new ImageRenderer("resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(15,15);
        this.hitPlayer = new HitPlayer();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.hitPlayer.run(this);
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