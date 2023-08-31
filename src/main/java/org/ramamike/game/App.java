package org.ramamike.game;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Display.create(800, 600, "Tanks");

        Timer t = new Timer(1000 / 60, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Display.render();
            }
        });
        t.setRepeats(true);
    }
}
