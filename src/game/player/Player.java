package game.player;

import core.GameObject;
import game.player.bullet.EnemyHitPlayer;
import game.player.bullet.SquareHitPlayer;
import input.MouseMotionInput;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;

public class Player extends GameObject implements PhysicBody {
    private PlayerShoot playerShoot;
    private PlayerHP playerHP;
    private ImageRenderer imageRenderer;
    private PlayerLife playerLife;
    private AnimationRenderer animationRenderer;
    public BoxCollider boxCollider;
    public EnemyHitPlayer enemyHitPlayer;
    public SquareHitPlayer squareHitPlayer;

    public Player() {
        this.imageRenderer = new ImageRenderer("resources/player/straight.png");
        this.renderer = this.imageRenderer;
        this.animationRenderer = new AnimationRenderer("resources/player/straight.png",
                "resources/player/straight_white.png",
                "resources/player/straight.png",
                "resources/player/straight_white.png");
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(30,30);
        this.enemyHitPlayer = new EnemyHitPlayer();
        this.squareHitPlayer = new SquareHitPlayer();
        this.playerHP = new PlayerHP(10);
        this.playerLife = new PlayerLife();
    }

    @Override
    public void run() {
        super.run();
        this.position.set(MouseMotionInput.instance.position);
        this.keepInMap();
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position);
        this.enemyHitPlayer.run(this);
        this.squareHitPlayer.run(this);
    }

    public void getHit() {
        this.isAlive = this.playerHP.run();
        if(this.isAlive) {
            animationRenderer.looped = false;
            this.renderer = this.animationRenderer;
        }
    }

    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    public void keepInMap() {
        if(this.position.x >= 375) {
            this.position.x = 375;
        }
        if(this.position.x <= 25) {
            this.position.x = 25;
        }
        if(this.position.y <= 25) {
            this.position.y = 25;
        }
        if(this.position.y >= 575) {
            this.position.y = 575;
        }
    }
}