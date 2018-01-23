package game.specialsquare;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.square.Square;

import java.util.Vector;

public class CircleSquare extends GameObject {
    private Vector2D velocity = new Vector2D();
    private Vector<Square> squares = new Vector<>();
    private FrameCounter frameCounter;
    private boolean spawned = false;

    public CircleSquare() {
        this.frameCounter = new FrameCounter(30);
        this.velocity.set(2, 2);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run() && !spawned) {
            for (double angle = 0.0; angle <= 360.0; angle += 360.0 / 15) {
                Square square = GameObjectManager.instance.recycle(Square.class);
                square.position.set((new Vector2D(50.0f, 0.0f)).rotate(angle)).addUp(60, 60);
                square.velocity.set(this.velocity);
                this.squares.add(square);
            }
            spawned = true;
            frameCounter.reset();
        }

        for (Square square: this.squares) {
            if (square.position.x >= 380 || square.position.x <= 0 ){
                this.velocity.x = -this.velocity.x;
            }
            if (square.position.y >= 580 || square.position.y <= 0){
                this.velocity.y = -this.velocity.y;
            }

        }

        for (Square square: this.squares){
            square.velocity.set(this.velocity);
        }
    }
}
