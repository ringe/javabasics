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
public class Triangle extends GeoObject {

	private double length = 1.0;
	private double width = 1.0;
	
	/*
	 * Parameterless constructor
	 */
	public Triangle() {
		super();
	}
	
	/*
	 * Constructor, takes length and width
	 */
	public Triangle(int l, int w) {
		super( 0, 0, true, Color.blue);
		length = l;
		width = w;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	/* (non-Javadoc)
	 * @see oblig1.GeoObject#getArea()
	 */
	@Override
	public double getArea() {
		return length * width;
	}

	/* (non-Javadoc)
	 * @see oblig1.GeoObject#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		return length * 2 + width * 2;
	}

	public String toString() {
		return "Rectangle: " + length + "w, " + width + "h, " + getArea() + " area and " + getPerimeter() + " around. " + getColor() + " x: " + getXPOs() + " y: " + getYPOs(); 
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}