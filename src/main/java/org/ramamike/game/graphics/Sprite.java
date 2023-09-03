package org.ramamike.game.graphics;

import org.ramamike.game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {
    private SpriteSheet sheet;
    private float scale;
    private BufferedImage image;
    public Sprite(SpriteSheet sheet, float scale) {
        this.sheet = sheet;
        this.scale = scale;
        image = sheet.getSprite(0);
        image = Utils.resize(image, (int)(image.getWidth()*scale), (int)(image.getHeight()*scale));
    }

    public void render(Graphics2D graphics, float x, float y) {
        graphics.drawImage(image, (int) x, (int)y, null);
    }
}
