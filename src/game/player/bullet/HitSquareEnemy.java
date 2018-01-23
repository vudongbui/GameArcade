package game.player.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.enemy.bullet.BulletEnemy;

public class HitSquareEnemy {
    public void run(BulletPlayer bulletPlayer) {
        BulletEnemy bulletEnemy = GameObjectManager.instance.checkCollider(bulletPlayer.boxCollider, BulletEnemy.class);
        if(bulletEnemy != null) {
            bulletPlayer.getHit();
            bulletEnemy.getHit();
        }
    }
}
