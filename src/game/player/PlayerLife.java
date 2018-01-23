package game.player;

import core.GameObject;
import renderer.ImageRenderer;


public class PlayerLife extends GameObject {
    public PlayerLife(){
        this.renderer = new ImageRenderer("resources/ui/heart.png");
    }
}
