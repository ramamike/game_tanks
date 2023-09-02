package org.ramamike.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {

    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;
    private static BufferedImage buffer;
    private static int[] bufferData;
    private static Graphics bufferGraphics;
    private static int clearColor;
    public static float delta=0;

    public  static BufferStrategy bufferStrategy;


    public static void create(int width, int height, String title, int _clearColor, int numBuffers) {
        if (created) return;
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop and close App     by cross

        content = new Canvas();
        Dimension size = new Dimension(width, height);
        content.setPreferredSize(size);
        window.setResizable(false); // not allowed change window size
        window.getContentPane().add(content); // add content without losing data cause window could have cross to close window
        window.pack(); // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
        bufferGraphics = buffer.getGraphics();
        ((Graphics2D)bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        clearColor=_clearColor;

        content.createBufferStrategy(numBuffers);
        bufferStrategy = content.getBufferStrategy();

        created = true;
    }

    public static void clear(){
        Arrays.fill(bufferData, clearColor);
    }

    public static void swapBuffer(){
        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(buffer, 0,0,null);
        bufferStrategy.show();
    }

    public static Graphics2D getGraphics2D() {
        return (Graphics2D) bufferGraphics;
    }

    public static void destroy() {
        if(!created) {
            return;
        }
        window.dispose();

    }

    public static void setTitle(String title) {
        window.setTitle(title);
    }

}
