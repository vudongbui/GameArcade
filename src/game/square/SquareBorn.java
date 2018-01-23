package game.square;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class SquareBorn extends GameObject {
    private Random random;
    private FrameCounter frameCounter;

    public SquareBorn() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(30);
    }

    public void run() {
        if(this.frameCounter.run()) {
            Square square = new Square();
            square.position.set(new Vector2D(random.nextInt(380)+10,0));
            square.velocity.set(new Vector2D(random.nextInt(3)-1, random.nextInt(4) + 3));
            GameObjectManager.instance.add(square);
            this.frameCounter.reset();
        }
    }
}
