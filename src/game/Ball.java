package game;

import java.awt.Color;

public class Ball extends Entity {
	private double [] spd = new double[2];
	
	private int scale;
    private int worldH, worldW;
    private int size;
    
    private double [] pos = new double [2];
    
	
	public Ball (Game game) {
		
		//Inicialização dos parametros do mundo
		this.worldH = game.HEIGHT;
	    this.worldW = game.WIDTH;
		this.scale = game.SCALE;
		
		//Inicialização do variaveis de velocidade
		// [0] = X | [1] = Y
		this.spd[0] = 5;
		this.spd[1] = 2;
		
		//Inicialização do variaveis de posição
		// [0] = X | [1] = Y
		this.pos[0] = worldW/2;
		this.pos[1] = worldH/2;
		
		this.size = 50;
	}
	
	@Override
	public void update(double delta) {
		//movimentação
		this.pos[0] = this.pos[0] + (this.spd[0]*delta);
		this.pos[1] = this.pos[1] + (this.spd[1]*delta);
		
		//colisão com tela
		if (this.pos[1] + size >= this.worldH) {
			if (this.spd[1] >= 0) {
				this.spd[1] =  this.spd[1] * -1;
			}
		}
		
		if (this.pos[1] <= 0) {
			if (this.spd[1] <= 0) {
				this.spd[1] =  this.spd[1] * -1;
			}
		}
		
		//colisão com tela
		//if (this.pos[1] + size >= )
		
	}
	
	@Override
	public void draw(java.awt.Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)pos[0], (int)pos[1] - this.size/2, size * this.scale, size *this.scale);
	}
	
	public double getX() {
		return this.pos[0];
	}
	
	public double getY() {
		return this.pos[1];
	}

}
