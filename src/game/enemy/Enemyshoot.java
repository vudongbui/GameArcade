package game.enemy;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import game.enemy.bullet.BulletEnemy;

import java.util.Random;

public class Enemyshoot {
    private Random random;
    private FrameCounter frameCounter;

    public Enemyshoot() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(20);
    }

    public void run(Enemy enemy) {
        if(this.frameCounter.run()) {
            BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletEnemy.class);
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(0.0f,random.nextInt(3)+3);
            this.frameCounter.reset();
        }
    }
}
