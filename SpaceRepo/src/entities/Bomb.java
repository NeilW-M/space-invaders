package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bomb {
	/**
	 * The x-position of the bomb
	 */
	public int x;
	
	/**
	 * The y-position of the bomb
	 */
	public int y;
	
	/**
	 * The speed of the bomb
	 */
	public int speed;
	
	/**
	 * The image used when rendering the bomb
	 */
	public BufferedImage img;
	
	/**
	 * Creates a new Bomb object for Space Invaders 
	 * 
	 * @param x
	 * 	The starting x-coord of the bomb
	 * @param y
	 * 	The starting y-coord of the bomb
	 * @param speed
	 * 	The starting speed of the bomb
	 * @param img
	 * 	The image that will be used when rendering the bomb
	 */
	public Bomb(int x, int y, int speed, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.img = img;
	}
	
	/**
	 * Creates a new Bomb object for Space Invaders by copying an existing object
	 * @param bomb
	 * 	The bomb object that will be copied onto a new bomb
	 */
	public Bomb(Bomb bomb) {
		this.x = bomb.x;
		this.y = bomb.y;
		this.speed = bomb.speed;
		this.img = bomb.img;
	}
	
	/**
	 * Moves the bomb DOWN using the pre-determined speed. By default it is the y-pos -= speed.
	 */
	public void move() {
		y -= speed;
	}
	
	/**
	 * Moves the bomb using a new speed inputted into the method. By default it is the y-pos += speed.
	 * @param speed
	 * 	The new speed that will overwrite the old speed and use it for moving
	 */
	public void move(int speed) {
		this.speed = speed;
		y += speed;
	}
	
	/**
	 * Checks to see if a bomb is off the screen, and if so, it will stop the bomb's movement.
	 * @param cutOff
	 * 	The value at which the bomb will stop moving down (y+) if the bomb's y-coordinate is greater than it.
	 */
	public void checkBombPosition(int cutOff) {
		if(this.y > cutOff) {
			speed = 0;
		}
	}
	
	/**
	 * Sets the img for the bomb
	 * @param img
	 * 	Takes in a BufferedImage for the image of the bomb
	 */
	public void setImage(BufferedImage img) {
		this.img = img;
	}
	
	/**
	 * Prints the Instance Variables of the Bomb. [x, y, speed]
	 */
	public void printInstanceVariables() {
		System.out.println("[" + x + ", " + y + ", " + speed +"]");
	}
	
	/**
	 * Renders the bomb to the screen.
	 * @param g
	 * 	The graphics object being used to render
	 */
	public void render(Graphics g) {
		g.drawImage(img, x, y, 20, 20, null);
	}
	
	/**
	 * Renders the bomb to the screen with a set img size.
	 * @param g
	 * 	The graphics object for rendering the bomb
	 * @param xSize
	 * 	The x-size of the image
	 * @param ySize
	 * 	The y-size of the image
	 */
	public void render(Graphics g, int xSize, int ySize) {
		g.drawImage(img, x, y, xSize, ySize, null);
	}
}
