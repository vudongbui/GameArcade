package game.player;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.player.bullet.BulletPlayer;

public class PlayerShoot {
    private FrameCounter frameCounter = new FrameCounter(20);

    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
            bulletPlayer.position.set(new Vector2D(player.position.x, player.position.y));
            BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
            bulletPlayer1.position.set(new Vector2D(player.position.x, player.position.y));
            bulletPlayer.velocity.set(new Vector2D(1.0f,5.0f));
            bulletPlayer1.velocity.set(new Vector2D(-1.0f,5.0f));
            this.frameCounter.reset();
        }
    }
}

