package core;

import game.square.Square;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public boolean isAlive;
    protected Renderer renderer;

    public GameObject() {
        this.position = new Vector2D();
        this.isAlive = true;
    }
    public void run() {

    }

    public void render(Graphics graphics) {
        if(this.renderer != null)
            this.renderer.render(graphics, this.position);
    }

}
