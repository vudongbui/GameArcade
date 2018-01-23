package renderer;

import core.Vector2D;

import java.awt.*;

public interface Renderer {
    void render(Graphics graphics, Vector2D position);
}
