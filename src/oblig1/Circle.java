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
public class Circle extends GeoObject {

	private double radius = 1.0;
	
	/*
	 * Parameterless constructor
	 */
	public Circle() {
		super();
	}
	
	/*
	 * Constructor, takes length and width
	 */
	public Circle(int r) {
		super( 1, 1, true, Color.green);
		radius = r;
	}
	
	public double getRadius() {
		return radius;
	}
	
	/* (non-Javadoc)
	 * @see oblig1.GeoObject#getArea()
	 */
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	/* (non-Javadoc)
	 * @see oblig1.GeoObject#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public String toString() {
		return "Circle: " + radius + "r, " + getArea() + " area " + getPerimeter() + " around. " + getColor() + " x: " + getXPos() + " y: " + getYPos();
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getXPos(), getYPos(), (int) radius, (int) radius);
	}

}