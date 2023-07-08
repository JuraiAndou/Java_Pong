package game;

//Interface de fisica. Define que todas as classes que a implementam obrigatoriamente deveram ter o método update()

public interface Physics {
	
	//Método responsavel por "atualiazar" as entidades, seja posição, colisão etc.. Como cada entidade possui um "comportamento" diferente, a implementação fica por conta delas
	public void update(double delta);
}	
