package game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Entity {

    private static int score;
    private int WORLD_HEIGHT;
    private int x, y, height, width, speed;
    private Game game;

    /**
     * Defines the Enemy constructor
     */
    public Enemy(Game game) {
        System.out.println("Enemy is initialized...");
        this.WORLD_HEIGHT = game.getH();
        this.x = 10; //adicionei ela so por enquanto, pra teste
        this.y = WORLD_HEIGHT /  2;
        this.height = 140;
        this.width = 10;
        this.game = game;
        this.speed = 4;
    }
    /**
     * Enemy Update function
     */
    @Override
    public void update(double delta) {
        /**
         * Makes the enemy follow the ball
         */
        if (this.getBodyBottom() < this.game.getBall().getBodyBottom()) {
            this.y += this.speed * delta;
        } else if (this.getBodyTop() > this.game.getBall().getBodyTop()) {
            this.y -= this.speed * delta;
        }
        
    }
    /**
     * Enemy Draw function
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.x, this.y - (this.height / 2) , this.width, this.height);
    }
    
	public void addScore() {
		score += 1;
	}
	
	public int getScore(){
		return score;
	}
	
    //getters de atributos
	public double getPosX(){
		return this.x;
	}
	
	public double getPosY(){
		return this.y  - (this.height / 2);
	}
   
    
	//getters de caixa de colisão
	public int getBodyTop() {
		return this.y - this.height/2; 
	}
	
	public int getBodyBottom() {
		return this.y + this.height/2;
	}
	
	public int getBodyLeft() {
		return this.x - this.width;
	}
	
	public int getBodyRight() {
		return this.x + this.width;
	}
}
