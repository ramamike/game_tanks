package org.ramamike.game.game.level;

import org.ramamike.game.graphics.SpriteSheet;
import org.ramamike.game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage image;
    private TileType type;

    public Tile(BufferedImage image, int scale, TileType type) {
        this.type = type;
        this.image = Utils.resize(image, image.getWidth()*scale, image.getHeight()*scale );
    }

    protected TileType getType() {
        return type;
    }

    protected void render(Graphics2D g, int x, int y){
        g.drawImage(image, x,y, null);
    }
}