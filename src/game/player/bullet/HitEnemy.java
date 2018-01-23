package game.player.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.enemy.Enemy;

public class HitEnemy {
    public void run(BulletPlayer bulletPlayer) {
        Enemy enemy = GameObjectManager.instance.checkCollider(bulletPlayer.boxCollider, Enemy.class);
        if(enemy != null) {
            bulletPlayer.getHit();
            enemy.getHit();
        }
    }
}
