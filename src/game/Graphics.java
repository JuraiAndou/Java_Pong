package game;

//Interface grafica. Define que todas as classes que a implementam obrigatoriamente deveram ter o método draw()

public interface Graphics {
	
	//Método responsavel por "desenhar" as entidades na tela. Como cada entidade possui uma "aparencia" diferente, a implementação fica por conta delas.
	public void draw();
}
