package org.ramamike.game.game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {
    private SpriteSheet sheet;
    private float scale;

    public Sprite(SpriteSheet sheet, float scale) {
        this.sheet = sheet;
        this.scale = scale;
    }

    public void render(Graphics2D graphics, float x, float y) {
        BufferedImage image = sheet.getSprite(0);
        graphics.drawImage(image, (int) x, (int)y, (int)(image.getWidth()*scale), (int)(image.getHeight()*scale), null);
    }
}
