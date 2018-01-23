package game.player.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.enemy.Enemy;
import game.player.Player;

public class EnemyHitPlayer {
    public void run(Player player) {
        Enemy enemy = GameObjectManager.instance.checkCollider(player.boxCollider, Enemy.class);
        if(enemy != null) {
            player.getHit();
            enemy.getHit();
        }
    }
}
