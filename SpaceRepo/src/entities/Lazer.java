package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

public class Lazer {
	/**
	 * The x-position of the lazer
	 */
	public int x;
	
	/**
	 * The y-position of the lazer
	 */
	public int y;
	
	/**
	 * The speed of the lazer
	 */
	public int speed;
	
	/**
	 * The image used for the lazer
	 */
	public BufferedImage img;
	
	/**
	 * Creates a new lazer for the ship.
	 * 
	 * @param x
	 * The start x-position of the lazer
	 * @param y
	 * The start y-position of the lazer
	 * @param img
	 * The image that is used when rendering the lazer
	 */
	public Lazer(int x, int y, int speed, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.img = img;
	}
	
	/**
	 * Creates a new lazer by copying another prexisting lazer
	 * @param lazer
	 * The lazer to be copied onto the new Lazer
	 */
	public Lazer(Lazer lazer) {
		this.x = lazer.x;
		this.y = lazer.y;
		this.speed = lazer.speed;
		this.img = lazer.img;
	}
	
	/**
	 * Checks the position of the lazer to make sure it stop moving outside the bounds of the screen. 
	 * 
	 * @param cutOff
	 * 	Represents the y-value at which the lazer will stop moving if it is LESS (<) than said value.
	 */
	public boolean checkLazerPosition(int cutOff) {
		if(this.y < cutOff) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Moves the lazer at the predetermined speed straight up
	 */
	public void move() {
		y += speed;
	}
	
	/**
	 * Moves the lazer straight up at a new speed that overwrites the old speed
	 * @param speed
	 * The new speed for the lazer to move at
	 */
	public void move(int speed) {
		this.speed = speed;
		y += speed;
	}
	
	public static void moveAll(List<Lazer> lazers) {
		for(int i = 0; i < lazers.size(); i++) {
			if(!lazers.get(i).checkLazerPosition(-25)) {
				lazers.get(i).move();
			}
			else if (lazers.get(i).checkLazerPosition(-25)) {
				lazers.remove(i);
			}
		}
	}
	
	/**
	 * Sets the image for the lazer to the input image
	 * @param img
	 * 	The input image that will be printed to represent the lazer
	 */
	public void setImage(BufferedImage img) {
		this.img = img;
	}
	
	/**
	 * Prints the Instance Variables of the lazer. [x, y, speed]
	 */
	public void printInstanceVariables() {
		System.out.println("[" + x + ", " + y + ", " + speed +"]");
	}
	
	/**
	 * Renders the specified lazer to the screen
	 * @param g
	 * 	The Graphics object being used to render is inputted into the method in order to print the lazer.
	 */
	public void render(Graphics g) {
		g.drawImage(img, x, y, 20, 20, null);
	}
	
	/**
	 * Renders all of the lazers in an array list
	 * @param g
	 * 	The Graphics object used for rendering
	 * @param lazers
	 * 	The List of lazers that will be rendered
	 */
	public static void renderAll(Graphics g, List<Lazer> lazers) {
		for(int i = 0; i < lazers.size(); i++) {
			lazers.get(i).render(g);
		}
	}
	
	/**
	 * Renders the specified lazer to the screen with a changable x and y size
	 * @param g
	 * 	The Graphics object being used to render 
	 * @param xSize
	 * 	The desired x-size for the image
	 * @param ySize
	 * 	The desired y-size for the image
	 */
	public void render(Graphics g, int xSize, int ySize) {
		g.drawImage(img,  x, y, xSize, ySize, null);
	}
}
