package game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Game extends Canvas {

    public static int WIDTH = 240;
    public static int HEIGHT = 120;
    public static int SCALE = 3;

    public static boolean running = true;
    public Game() {
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();

        JFrame frame = new JFrame("Pong");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        System.out.println("Game is initializing...");
        game.gameLoop();
    }

    /**
     * Defines a function for the Game Loop
     */
    public void gameLoop() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        long timer = System.currentTimeMillis();
        int frames = 0 ;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            // Fixes the upadate at 60 times per second
            while (delta >= 1) {
                update(delta);
                updates++;
                delta--;
            }
            if(running)
                draw();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, FPS: " + frames);
                updates = 0;
                frames = 0;
            }
        }
    }

    /**
     * Defines a function to update the game
     */
    public void update(double delta) {

    }

    /**
     * Defines a function to draw the game
     */
    public void draw() {

    }
}
