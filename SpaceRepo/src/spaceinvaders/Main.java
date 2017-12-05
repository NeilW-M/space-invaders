package spaceinvaders;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import entities.Lazer;
import entities.Player;

/**
 * Simple version of the game Space Invaders.
 * 
 * @author Neil
 * @version Version 1
 */
public class Main extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private List<BufferedImage> imgs = new ArrayList<BufferedImage>();
	private List<Lazer> lazers = new ArrayList<Lazer>();
	
	private Canvas canvas = new Canvas();
	private Keys kl = new Keys();
	
	Player ship;
	
	/**
	 * Main constructor that sets up the game and 
	 * creates the basic window for the game.
	 */
	public Main() {
		loadAssets();
		
		setBounds(0, 0, 400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Space Invaders!");
		setResizable(false);
		
		addKeyListener(kl);
		
		add(canvas);
		
		setVisible(true);
		
		canvas.createBufferStrategy(2);
	}
	
	/**
	 * Loads all of the images for the game from the resources folder
	 */
	public void loadAssets() {
		try {
			imgs.add(ImageIO.read(new File("res/spaceship.png"))); //0
			imgs.add(ImageIO.read(new File("res/lazer.png"))); //1
			imgs.add(ImageIO.read(new File("res/bomb.png"))); //2
			imgs.add(ImageIO.read(new File("res/invaderOne.png"))); //3
			imgs.add(ImageIO.read(new File("res/invaderTwo.png"))); //4
			imgs.add(ImageIO.read(new File("res/invaderThree.png"))); //5
			ship = new Player(180, 415, 0, 0, imgs.get(0)); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The update method for all the game logic. It runs at a set pace of around 60 times a second.
	 */
	public void update() {
		ship.moveX();
		Lazer.moveAll(lazers);
		
	}
	
	/**
	 * The master rendering method for the game, that runs as fast as possible.
	 */
	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		
		//Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//Ship
		ship.render(g);
		
		//Lazers
		Lazer.renderAll(g, lazers);
		
		bs.show();
		g.dispose();
	}
	
	/**
	 * The method that sets up the runspeed of the program
	 */
	public void run() {
		 long lastTime = System.nanoTime();
	        double nanoSecondConversion =   1000000000.0 / 60;
	        double deltaSeconds = 0;
	        while(true) {
	            long now = System.nanoTime();
	            deltaSeconds += (now - lastTime) / nanoSecondConversion;
	            while(deltaSeconds >= 2) {
	                update();
	                deltaSeconds = 0;
	            }
	            render();
	            lastTime = now;
	        }
	}
	
	public static void main(String[] args) {
		Main game = new Main();
		Thread thrd = new Thread(game);
		thrd.start();
	}
	
	private class Keys extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
				ship.xSpeed = 4;
			if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
				ship.xSpeed = -4;
			if(key == KeyEvent.VK_SPACE) 
				lazers.add(new Lazer(ship.x + 15, ship.y - 20, -10, imgs.get(1)));
			
		}
		
		public void keyReleased(KeyEvent e) {
			
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
				ship.xSpeed = 0;
			if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
				ship.xSpeed = 0;
			
		}
	}
}
