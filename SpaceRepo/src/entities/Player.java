package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	/**
	 * The x-position of the player
	 */
	public int x;
	
	/**
	 * The y-position of the player
	 */
	public int y;
	
	/**
	 * The x-speed of the player
	 */
	public int xSpeed;
	
	/**
	 * The y-speed of the player
	 */
	public int ySpeed;
	
	/**
	 * The image rendered to represent the player
	 */
	BufferedImage img;
	
	/**
	 * Creates a new Player object with the desired parameters.
	 * @param x
	 * 	The starting x-position of the player
	 * @param y
	 * 	The starting y-position of the player
	 * @param xSpeed
	 * 	The starting xSpeed of the player
	 * @param ySpeed
	 * 	The starting ySpeed of the player
	 * @param img
	 * 	The image that will be rendered to represent the player
	 */
	public Player(int x, int y, int xSpeed, int ySpeed, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.img = img;
	}
	
	/**
	 * Creates a new Player object by copying an existing Player object.
	 * @param player
	 * 	The Player object that will be copied into a new Player object
	 */
	public Player(Player player) {
		this.x = player.x;
		this.y = player.y;
		this.xSpeed = player.xSpeed;
		this.ySpeed = player.ySpeed;
		this.img = player.img;
	}
	
	/**
	 * Moves the ship horizontally at the predetermined speed
	 */
	public void moveX() {
		x += xSpeed;
	}
	
	/**
	 * Moves the ship horizontally at the new desired speed WITHOUT overwriting the old value.
	 * @param speed
	 * 	The speed value the ship will follow ONLY WITHIN THIS METHOD
	 */
	public void moveX(int speed) {
		x += speed;
	}
	
	/**
	 * Moves the ship vertically at the predetermined speed.
	 */
	public void moveY() {
		y += ySpeed;
	}
	
	/**
	 * Moves the ship vertically at the new desired speed WITHOUT overwriting the old value.
	 * @param speed
	 * 	The speed value the ship will follow ONLY WITHIN THIS METHOD
	 */
	public void moveY(int speed) {
		y += speed;
	}
	
	/**
	 * Checks to see if the player if out of bounds horizontally
	 * @param leftBound
	 * 	Leftmost possible position of the player
	 * @param rightBound
	 * 	Rightmost possible position of the player
	 */
	public void testXPosition(int leftBound, int rightBound) {
		if(x < leftBound) {
			x = leftBound;
		}
		if(x > rightBound) {
			x = rightBound;
		}
	}
	
	/**
	 * Checks to see if the player is out of bounds vertically
	 * @param topBound
	 * 	Topmost possible position of the player
	 * @param botBound
	 * 	Bottommost possible position of the player
	 */
	public void testYPosition(int topBound, int botBound) {
		if(y < topBound) {
			y = topBound;
		}
		if(y > botBound) {
			y = botBound;
		}
	}
	
	/**
	 * Sets the ship's image to a new image.
	 * @param img
	 * 	The image that the ship will now use.
	 */
	public void setImage(BufferedImage img) {
		this.img = img;
	}
	
	/**
	 * Prints the Instance Variables of the Player object. [x, y, xSpeed, ySpeed]
	 */
	public void printInstanceVariables() {
		System.out.println("[" + x + ", " + y + ", " + xSpeed + ", " + ySpeed + "]");
	}
	
	/**
	 * Renders the ship to the screen
	 * @param g
	 * 	The Graphics object being used to render
	 */
	public void render(Graphics g) {
		g.drawImage(img, x, y, 50, 50, null);
	}
	
	/**
	 * Renders the ship to the screen with a changable size
	 * @param g
	 * 	The Graphics object that is being used to render
	 * @param xSize
	 * 	The x-size of the ship
	 * @param ySize
	 * 	The y-size of the ship
	 */
	public void render(Graphics g, int xSize, int ySize) {
		g.drawImage(img, x, y, xSize, ySize, null);
	}
}
