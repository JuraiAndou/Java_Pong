package game;


public class Entity implements Graphics, Physics{
	public void update(double delta) {
		// TODO Auto-generated method stub
		
	}
	
	public void draw(java.awt.Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	
	//getters para paramentros das entidades
    public double getPosX() {
    	return 0;
    }

    public double getPosY() {
    	return 0;
    }
    
    public int getScore() {
    	return 0;
    }
    
    public void addScore(){
    }
    
    //getters de "caixa de colisão"
    public int getBodyTop() {
    	return 0;
    }

    public int getBodyBottom() {
    	return 0;
    }
    
    public int getBodyLeft() {
    	return 0;
    }
    
    public int getBodyRight() {
    	return 0;
    }
    
}
