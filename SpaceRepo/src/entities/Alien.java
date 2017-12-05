package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Alien {
	/**
	 * The x-position of the alien
	 */
	public int x;
	
	/**
	 * The y-position of the alien
	 */
	public int y;
	
	/**
	 * The horizontal speed of the alien
	 */
	public int xSpeed;
	
	/**
	 * The vertical speed of the alien
	 */
	public int ySpeed;
	
	/**
	 * The type of alien: blue, green, or red
	 */
	public int type;
	
	/**
	 * The image that is rendered to represent the alien
	 */
	BufferedImage img;
	
	/**
	 * Creates a new Alien object with custom parameters.
	 * @param x
	 * 	The starting x-position of the alien
	 * @param y
	 * 	The starting y-position of the alien
	 * @param xSpeed
	 * 	The starting horizontal speed of the alien
	 * @param ySpeed
	 * 	The starting vertical speed of the alien
	 * @param type
	 * 	The type of the alien
	 * @param img
	 * 	The image used when rendering the alien
	 */
	public Alien(int x, int y, int xSpeed, int ySpeed, int type, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.type = type;
		this.img = img;
	}
	
	/**
	 * Creates a new Alien object by copying another 
	 * @param alien
	 * 	The Alien object that will be copied into a new object
	 */
	public Alien(Alien alien) {
		this.x = alien.x;
		this.y = alien.y;
		this.xSpeed = alien.xSpeed;
		this.ySpeed = alien.ySpeed;
		this.type = alien.type;
		this.img = alien.img;
	}
	
	/**
	 * Moves the alien horizontally with the set speed.
	 */
	public void moveX() {
		x += xSpeed;
	}
	
	/**
	 * Moves the alien horizontally with a new speed
	 * @param speed
	 * 	The new speed at which the alien will move at
	 */
	public void moveX(int speed) {
		xSpeed = speed;
		x += xSpeed;
	}
	
	/**
	 * Moves the alien vertically with the set speed.
	 */
	public void moveY() {
		y += ySpeed;
	}
	
	/**
	 * Moves the alien vertically with a new speed.
	 * @param speed
	 * 	The new speed at which it will move.
	 */
	public void moveY(int speed) {
		ySpeed = speed;
		y += ySpeed;
	}
	
	/**
	 * Prints the Instance Variables of the Alien object. [x, y, xSpeed, ySpeed, type]
	 */
	public void printInstanceVariables() {
		System.out.println("[" + x + ", " + y + ", " + xSpeed + ", " + ySpeed + ", " + type + "]");
	}
	
	/**
	 * Sets the image for the alien
	 * @param img
	 * 	The image that will render for the alien
	 */
	public void setImage(BufferedImage img) {
		this.img = img;
	}
	
	/**
	 * Renders the alien to the screen at the size 50x50
	 * @param g
	 * 	The Graphics object used to render the alien
	 */
	public void render(Graphics g) {
		g.drawImage(img, x, y, 50, 50, null);
	}
	
	/**
	 * Renders the alien to the screen at a custom size
	 * @param g
	 * 	The Graphics object that will render the image
	 * @param xSize
	 * 	The xSize of the image
	 * @param ySize
	 * 	The ySize of the image
	 */
	public void render(Graphics g, int xSize, int ySize) {
		g.drawImage(img, x, y, xSize, ySize, null);
	}
}
