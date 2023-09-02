package org.ramamike.game.game;

import org.ramamike.game.Display;
import org.ramamike.game.utils.Time;

import java.awt.*;

public class Game implements Runnable {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Tanks";
    public static final int CLEAR_COLOR = 0xff000000;
    public static final int NUM_BUFFERS = 3;

    public static final float UPDATE_RATE = 60.0f;
    public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;
    public static final long IDLE_TIME = 1;

    private boolean running;
    private Thread gameThread;
    private Graphics2D graphics2D;

    // temp
    float x = 350;
    float y = 250;
    float delta = 0;
    float radius = 50;


    // temp end

    public Game() {
        running = false;
        Display.create(WIDTH, HEIGHT, TITLE, CLEAR_COLOR, NUM_BUFFERS);
        graphics2D = Display.getGraphics2D();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stop() {

        if (!running) {
            return;
        }
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cleanUp();
    }

    @Override
    public void run() {

        int fps = 0;
        int upd = 0;
        int updl = 0;

        long count = 0;

        float delta = 0;

        long lastTime = Time.get();
        while (running) {
            long now = Time.get();
            long elapsedTime = now - lastTime;
            lastTime = now;

            count += elapsedTime;

            boolean render = false;

            delta += (elapsedTime / UPDATE_INTERVAL);
            while (delta > 1) {
                update();
                upd++;
                delta--;
                if (render) {
                    updl++;
                } else {
                    render = true;
                }
            }
            if (render) {
                render();
                fps++;
            } else {
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (count >= Time.SECOND) {
                Display.setTitle(TITLE + " || fps: " + fps + " | upd: " + upd + " | updl: " + updl);
                fps = 0;
                upd = 0;
                updl = 0;
                count = 0;
            }

        }
    }

    private void update() {
        delta += 0.02f;
    }

    private void render() {
        Display.clear();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval( (int)(x+Math.sin(delta)*200), (int)y, (int)(radius*2), (int)(radius*2));
        Display.swapBuffer();
    }

    private void cleanUp() {
        Display.destroy();
    }

}
