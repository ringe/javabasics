/**
 * 
 */
package oblig1;

import java.awt.Color;
import java.awt.Graphics;

import org.eclipse.swt.graphics.GC;

/**
 * @author runar
 * 
 */
// GeoObject.java:
public abstract class GeoObject {
	protected Color color = Color.white;
	protected boolean filled;
	protected int xPos;
	protected int yPos;
	protected int dx = 10;
	protected int dy = 10;
	protected int speedFactor =1;
	protected boolean movable;
	protected int panelWidth;
	protected int panelHeight;

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
	//ny konstruktør
	protected GeoObject(int x, int y, boolean f, Color c,int panelWidth, int panelHeight) {
		xPos = x;
		yPos = y;
		filled = f;
		color = c;
		this.panelHeight = panelHeight;
		this.panelWidth = panelWidth;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSpeed() {
		return speedFactor;
	}

	public void setSpeed(int speed) {
		this.speedFactor = speed;
	}

	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	public int getXPos(){return xPos;};

	public int getYPos(){return yPos;};

	// set metoder for xPos, yPos
	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public abstract double getArea();

	public abstract double getPerimeter();
	
	public abstract void draw(GC gc);
	
	public abstract void move();


}