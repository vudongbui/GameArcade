package game.player.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.player.Player;
import game.square.Square;

public class SquareHitPlayer {
    public void run(Player player) {
        Square square = GameObjectManager.instance.checkCollider(player.boxCollider, Square.class);
        if(square != null) {
            player.getHit();
            square.getHit();
        }
    }
}
