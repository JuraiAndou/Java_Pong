package game;

import java.awt.Color;

public class Ball extends Entity {
	private double [] spd = new double[2];
	
	private int scale;
    private int worldH, worldW;
    private int size;
    private Player player;
    private Enemy enemy;
    
    private double [] pos = new double [2];
    
	
	public Ball (Game game) {
		
		//Inicialização dos parametros do mundo
		this.worldH = game.getH();
	    this.worldW = game.getW();
		this.scale = game.getSc();
		
		//Inicialização do variaveis de velocidade
		// [0] = X | [1] = Y
		this.spd[0] = 5;
		this.spd[1] = 2;
		
		//Inicialização do variaveis de posição
		// [0] = X | [1] = Y
		this.pos[0] = worldW/2;
		this.pos[1] = worldH/2;
		
		//inicializando entidades relacionadas
		this.player = (Player) game.getPlayer();
		this.enemy =  (Enemy) game.getEnemy();
		
		this.size = 20;
	}
	
	@Override
	public void update(double delta) {
		//movimentação
		this.pos[0] = this.pos[0] + (this.spd[0]*delta);
		this.pos[1] = this.pos[1] + (this.spd[1]*delta);
		
		//colisão com tela
		if (this.pos[1] + size/2 >= this.worldH) {
			if (this.spd[1] >= 0) {
				this.spd[1] =  this.spd[1] * -1;
			}
		}
		
		if (this.pos[1] - size/2 <= 0) {
			if (this.spd[1] <= 0) {
				this.spd[1] =  this.spd[1] * -1;
			}
		}
		
		//colisão com player
		if (this.getBodyBottom() >= this.player.getBodyTop() && this.getBodyTop() <= this.player.getBodyBottom() && this.getBodyRight() >= this.player.getBodyLeft()){
			if (this.spd[0] >= 0) {
				this.spd[0] = this.spd[0] * -1;
			}
		}
		
		//colisão com o enemy
		if (this.getBodyBottom() >= this.enemy.getBodyTop() && this.getBodyTop() <= this.enemy.getBodyBottom() &&  this.getBodyLeft() <= this.enemy.getBodyRight()){
			if (this.spd[0] <= 0) {
				this.spd[0] = this.spd[0] * -1;
			}
		}
		
		//colisão com o "gol"
		if (this.pos[0] + size >= this.worldW){
			this.resetBall();
		}else if (this.pos[0] <= 0) {
			this.resetBall();
		}
	}
	
	@Override
	public void draw(java.awt.Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)pos[0], (int)pos[1] - this.size/2, size * this.scale, size *this.scale);
	}
	
	public double getPosX(){
		return this.pos[0];
	}
	
	public double getPosY(){
		return this.pos[1] - this.size/2;
	}
	
	//getters de caixa de colisão
	public int getBodyTop() {
		return (int) (this.pos[1]);
	}
		
	public int getBodyBottom() {
		return (int) (this.pos[1] + size);
	}
		
	public int getBodyLeft() {
		return (int) this.pos[0];
	}
		
	public int getBodyRight() {
		return (int) (this.pos[0] + this.size);
	}
	
	public void resetBall(){
		this.pos[0] = worldW/2;
		this.pos[1] = worldH/2;
		this.spd[0] = this.spd[0] *-1;
	}

}
