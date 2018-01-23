package renderer;

import core.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRenderer implements Renderer {
    private BufferedImage image;

    public ImageRenderer(String url) {
        this.image = Utils.loadImage(url);
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        if(this.image != null) {
            graphics.drawImage(this.image, (int)position.x - this.image.getWidth() / 2, (int)position.y - this.image.getHeight() / 2, null);
        }
    }
}
