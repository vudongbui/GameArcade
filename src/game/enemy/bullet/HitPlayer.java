package game.enemy.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.player.Player;

public class HitPlayer {
    public void run (BulletEnemy bulletEnemy) {
        Player player = GameObjectManager.instance.checkCollider(bulletEnemy.boxCollider, Player.class);
        if(player != null) {
            bulletEnemy.getHit();
            player.getHit();
        }
    }
}
