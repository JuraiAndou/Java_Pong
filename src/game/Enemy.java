package game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity {

    public int score;
    private int speed;
    private int WORLD_HEIGHT, WORLD_WIDTH;

    /**
     * Defines the Enemy constructor
     */
    public Enemy(Game game) {
        System.out.println("Enemy is initialized...");
        this.WORLD_HEIGHT = game.HEIGHT;
        this.WORLD_WIDTH = game.WIDTH;

    }
    /**
     * Enemy Update function
     */
    @Override
    public void update(double delta) {
        
    }
    /**
     * Enemy Draw function
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(50, 50, 50, 50);
    }
}
