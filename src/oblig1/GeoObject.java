/**
 * 
 */
package oblig1;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author runar
 * 
 */
// GeoObject.java:
public abstract class GeoObject {
	private Color color = Color.white;
	private boolean filled;
	private int xPos;
	private int yPos;
	private int speed;
	private boolean movable;

	// Default constructor
	protected GeoObject() {
	}

	// Lag et geo object*/
	protected GeoObject(int x, int y, boolean f, Color c) {
		xPos = x;
		yPos = y;
		filled = f;
		color = c;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	public int getXPOs(){return xPos;};

	public int getYPOs(){return yPos;};

	// set metoder for xPos, yPos
	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public abstract double getArea();

	public abstract double getPerimeter();
	
	public abstract void draw(Graphics g);

}