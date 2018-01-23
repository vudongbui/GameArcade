package renderer;

import core.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimationRenderer implements Renderer {
    public boolean looped;
    private List<BufferedImage> list;
    private int index;

    public AnimationRenderer(String... urls) {
        this.list = new ArrayList<>();
        Arrays.asList(urls).stream().forEach(url -> {
            list.add(Utils.loadImage(url));
        });
        this.index = 0;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        BufferedImage image = this.list.get(this.index);
        graphics.drawImage(image,(int) position.x - image.getWidth() / 2, (int) position.y - image.getHeight() / 2, null);
        if (this.index == this.list.size() - 1) {
            index = 0;
            looped = true;
        }

        if (this.index != this.list.size() - 1 && !looped)  {
            this.index++;
        }
    }
}
