package input;

import core.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionInput implements MouseMotionListener {
    public Vector2D position;
    public static MouseMotionInput instance = new MouseMotionInput();

    private MouseMotionInput() {
        this.position = new Vector2D();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.position.set(e.getX(), e.getY() - 15);
    }
}
