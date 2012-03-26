/**
 * 
 */
package oblig1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * @author runar
 *
 */
public class Triangle extends GeoObject {

	private double height = 1.0;
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
		height = l;
		width = w;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
	
	/* (non-Javadoc)
	 * @see oblig1.GeoObject#getArea()
	 */
	@Override
	public double getArea() {
		return height * width;
	}

	/* (non-Javadoc)
	 * @see oblig1.GeoObject#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		return height * 2 + width * 2;
	}

	public String toString() {
		return "Rectangle: " + height + "w, " + width + "h, " + getArea() + " area and " + getPerimeter() + " around. " + getColor() + " x: " + getXPos() + " y: " + getYPos(); 
	}

	@Override
	public void draw(Graphics g) {
		Polygon p = new Polygon();
		p.addPoint(getXPos(), getYPos());
		p.addPoint(getXPos() + (int) width, getYPos());
		p.addPoint(getXPos() + (int) width/2, getYPos() + (int) height);
		g.drawPolygon(p);		
	}
}