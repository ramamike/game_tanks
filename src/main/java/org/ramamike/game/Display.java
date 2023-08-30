package org.ramamike.game;

import javax.swing.*;
import java.awt.*;

public abstract class Display {

    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;

    public static void create(int width, int height, String title) {
        if(created) return;
        window=new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop and close App     by cross

        content =new Canvas();
        Dimension size = new Dimension(width,height);
        content.setPreferredSize(size);
        window.setResizable(false); // not allowed change window size
        window.getContentPane().add(content); // add content without losing data cause window could have cross to close window
        window.pack(); // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


}
