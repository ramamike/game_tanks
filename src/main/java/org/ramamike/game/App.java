package org.ramamike.game;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Display.create(800, 600, "Tanks", 0xff00ff00, 3);

        Timer t = new Timer(1000 / 60, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Display.clear();
                Display.render();
                Display.swapBuffer();
            }
        });
        t.setRepeats(true);
        t.start();
    }
}
