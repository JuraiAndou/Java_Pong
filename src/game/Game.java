package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends Canvas {
    private static final long serialVersionUID = 1L;
    
	public Inputs input;
    protected int WIDTH = 640;
    protected int HEIGHT = 480;
    protected static int SCALE = 1;

    private BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    public static boolean running = true;

    ArrayList<Entity> entities = new ArrayList<>();
    private Entity enemy;
    private Entity player;
    private Entity ball;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        //inputSystem initialization
        this.input = new Inputs(this);
        
        //player initialization
        this.player = new Player(this);
        entities.add(player);
        
        // Enemy initialization
        this.enemy = new Enemy(this);
        entities.add(enemy);
        
        // Ball initialization
        this.ball = new Ball(this);
        entities.add(ball);
    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();

        JFrame frame = new JFrame("Pong");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        System.out.println("Game is initializing...");
        game.gameLoop();
    }

    /**
     * Defines a function for the Game Loop
     */
    public void gameLoop() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        long timer = System.currentTimeMillis();
        int frames = 0 ;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            // Fixes the update at 60 times per second
            while (delta >= 1) {
                update(delta);
                updates++;
                delta--;
            }
            if(running)
                draw();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, FPS: " + frames);
                updates = 0;
                frames = 0;
            }
        }
    }

    /**
     * Defines a function to update the game
     */
    public void update(double delta) {
        // Calls the update function of the entities
        for (Entity entity : entities) {
            entity.update(delta);
        }
       
    }

    /**
     * Defines a function to draw the game
     */
    public void draw() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = layer.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // Calls the draw function of the entities
        for (Entity entity : entities) {
            entity.draw(g);
        }

        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        bs.show();
    }
    
    //getters das entidades 
    //isso é feito para que outras entidades interessadas como a "bola", possam acessar algumas caracteristacas de outras entidades por meios de seus métodos.
    public Entity getPlayer() {
    	return player;
    }
    
    public Entity getEnemy() {
    	return enemy;
    }
    
    public Entity getBall() {
    	return ball;
    }
}
