package game;

import java.awt.Color;

public class Player extends Entity {
	
	private Inputs inputListener;
	
	//Variaveis do frame
	private int scale;
    private int worldW;
	
    
    //variaveis de posição
	private int [] pos; 
	
	//variavel de tamanho, para calculo de colisão
	private int [] size = new int [2];
	
	private static int score;
	
	public Player(Game game){
		System.out.println("Player initialized....");
		
		//inicialização das variaveis que obtem os parametros do Jframe.
	    this.worldW = game.getW();
		this.scale = game.getSc();
		
		//iniciaando variavel que controla os inputs
		this.inputListener = game.getInputSys();
		
		//Inicialização do variaveis de posição
		// [0] = X | [1] = Y
		this.pos = new int [2];
		
		//inicializando variaveis de tamanho
		// [0] = X | [1] = Y
		this.size[0]=  10 * this.scale;
		this.size[1]= 140 *this.scale;
	}

	@Override
	public void update(double delta) {
		this.pos[1] = this.inputListener.getY();
		
	}

	@Override
	public void draw(java.awt.Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(pos[0] + this.worldW - 20, pos[1] - this.size[1]/2, this.size[0], this.size[1]);

	}
	
	public void addScore() {
		score += 1;
	}
	
	public int getScore(){
		return score;
	}
	
	//Getters de atributos
	public double getPosX(){
		return this.pos[0] + this.worldW - 20;
	}
	
	public double getPosY(){
		return this.pos[1] - this.size[1]/2;
	}
	
	
	//getters de caixa de colisão
	public int getBodyTop() {
		return pos[1] - this.size[1]/2;
	}
	
	public int getBodyBottom() {
		return pos[1] + this.size[1]/2;
	}
	
	public int getBodyLeft() {
		return pos[0] + this.worldW - this.size[0] -10;
	}
	
	public int getBodyRight() {
		return pos[0] + this.worldW + this.size[0];
	}
}
