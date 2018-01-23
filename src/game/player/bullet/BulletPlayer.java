package game.player.bullet;

import core.GameObject;
import core.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import utils.Utils;

public class BulletPlayer extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private HitSquare hitSquare;
    private HitEnemy hitEnemy;
    private  HitSquareEnemy hitSquareEnemy;

    public BulletPlayer() {
        this.renderer = new ImageRenderer("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);
        this.hitSquare = new HitSquare();
        this.hitEnemy = new HitEnemy();
        this.hitSquareEnemy = new HitSquareEnemy();
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
        this.boxCollider.position.set(this.position);
        this.hitSquare.run(this);
        this.hitEnemy.run(this);
        this.hitSquareEnemy.run(this);
        if(this.position.y <= 0)
            this.isAlive = false;
    }

    public void getHit() {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
