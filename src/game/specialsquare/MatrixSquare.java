package game.specialsquare;

import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.square.Square;

import java.util.Vector;

public class MatrixSquare extends GameObject {
    String[][] s = {
            {"*"," ","*"},
            {"*"," ","*"},
            {"*","*","*"},
            {"*"," ","*"},
            {"*"," ","*"}
    };
    Vector<Square> vector;
    Vector2D velocity;
    float y;
    float vX = 2;
    boolean goDown;
    public MatrixSquare() {
        vector = new Vector<>();
        velocity = new Vector2D(vX,0.0f);
        for (int i = 0; i < s.length; i++){
            for (int j = 0; j < s[0].length; j++){
                if (s[i][j].equalsIgnoreCase("*")){
                    Square square = GameObjectManager.instance.recycle(Square.class);
                    square.position.set(20*j + 10, 20*i + 10);
                    vector.add(square);
                }
            }
        }
        this.goDown = false;
    }

    @Override
    public void run() {
        super.run();
        for (Square square: vector){
            if (square.position.x <= 0||square.position.x >= 400) {
                if (!this.goDown) {
                    this.y = square.position.y;
                    this.goDown = true;
                }
                this.velocity.set(0,3);
                if (square.position.y == y + 15){
                    this.vX = -this.vX;
                    this.velocity.set(vX, 0);
                    this.goDown = false;
                }
                break;
            }
        }
        for (Square square: vector){
            square.velocity.set(this.velocity);
        }
    }
}