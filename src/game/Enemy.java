package game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity {

    public int score;
    private int speed;
    private int WORLD_HEIGHT, WORLD_WIDTH;
    private int x, y, height, width;

    /**
     * Defines the Enemy constructor
     */
    public Enemy(Game game) {
        System.out.println("Enemy is initialized...");
        this.WORLD_HEIGHT = game.HEIGHT;
        this.WORLD_WIDTH = game.WIDTH;
        this.x = 10; //adicionei ela so por enquanto, pra teste
        this.y = WORLD_HEIGHT /  2;
        this.height = 140;
        this.width = 10;

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
        g.setColor(Color.red);
        g.fillRect(this.x, this.y - (this.height / 2) , this.width, this.height);
    }
    
    
	//getters de caixa de colisão
	public int getEnemyTop() {
		return this.y - this.height/2; 
	}
	
	public int getEnemyBottom() {
		return this.y + this.height/2;
	}
	
	public int getEnemyLeft() {
		return this.x - this.width;
	}
	
	public int getEnemyRight() {
		return this.x + this.width;
	}
}
