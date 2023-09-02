package org.ramamike.game.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourcesLoader {
    public static final String PATH = "src/main/resources/";

    public static BufferedImage ladImage(String fileName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(PATH+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
