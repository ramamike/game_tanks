package org.ramamike.game.graphics;

import org.ramamike.game.utils.ResourcesLoader;

import java.awt.image.BufferedImage;

public class TextureAtlas {
    BufferedImage image;

    public TextureAtlas(String imageName) {
        this.image = ResourcesLoader.ladImage(imageName);
    }

    public BufferedImage cut(int x, int y, int w, int h) {
        return image.getSubimage(x,y,w,h);
    }
}
