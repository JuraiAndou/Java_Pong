package game;

import java.awt.Color;

public class Player extends Entity {
	
	private Inputs inputListener;
	private int scale;
    private int worldH, worldW;
	
	private int [] pos; 
	
	private static int score;
	
	public Player(Game game){
		System.out.println("Player initialized....");
		
		//inicialização das variaveis que obtem os parametros do Jframe.
		this.worldH = game.HEIGHT;
	    this.worldW = game.WIDTH;
		this.scale = game.SCALE;
		
		
		this.inputListener = game.input;
		this.pos = new int [2];
	}

	@Override
	public void update(double delta) {
		this.pos[1] = this.inputListener.getY();
		
	}

	@Override
	public void draw(java.awt.Graphics g) {
		g.setColor(Color.white);
		g.fillRect(pos[0] + this.worldW - 20, pos[1] - 70, 10 * this.scale, 140 *this.scale);
		
	}
	
	public void addScore() {
		score += 1;
	}
	
	public int getScore(){
		return score;
	}
}
