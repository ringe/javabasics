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
		super( 1, 1, true, Color.green,300,300);
		radius = r;
	}
	
	//new constructor
	public Circle(int x, int y, boolean f, Color c,int panelWidth, int panelHeight, int radius) {
		xPos = x;
		yPos = y;
		filled = f;
		color = c;
		this.panelHeight = panelHeight;
		this.panelWidth = panelWidth;
		this.radius = radius;
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
	public void draw(GC g) {
		g.drawOval(getXPos(), getYPos(), (int) radius, (int) radius);
	}
	public void move()
	{
		xPos += dx;
        yPos += dy;
       
        
        
        if (xPos < 0)
        {
            xPos = 0;
            dx = -dx;
        }

        if (xPos + 2*radius >= panelWidth)
        {
            xPos = (int) ((double)panelWidth - 2*radius);
            dx = -dx;
        }

        if (yPos < 0)
        {
            yPos = 0;
            dy = -dy;
        }

        if (yPos + 2*radius >= panelHeight)
        {
            yPos = (int) (panelHeight - 2*radius);
            dy = -dy;
        }
	}

}