package game.enemy;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;

import java.util.Random;

public class EnemyBorn extends GameObject {
    private Random random;
    private FrameCounter frameCounter;

    public EnemyBorn() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(50);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
            enemy.position.set(random.nextInt(360) + 20, 0.0f);
            enemy.velocity.set(random.nextInt(5)-2, random.nextInt(3) + 2);
            this.frameCounter.reset();
        }
    }
}