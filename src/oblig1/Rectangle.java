/**
 * 
 */
package oblig1;

import java.awt.Graphics;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

/**
 * @author runar
 *
 */
public class Rectangle extends GeoObject {

	private double length = 1.0;
	private double width = 1.0;
	
	/*
	 * Parameterless constructor
	 */
	public Rectangle() {
		super();
	}
	
	
	public Rectangle(int x, int y, boolean f, Color c, int width, int length) {
		xPos = x;
		yPos = y;
		filled = f;
		color = c;
		this.width = width;
		this.length = length;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getHeight() {
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
		return "Rectangle: " + length + "w, " + width + "h, " + getArea() + " area and " + getPerimeter() + " around. " + getColor() + " x: " + getXPos() + " y: " + getYPos(); 
	}

	@Override
	public void draw(GC g) {
		g.setBackground(color);
		g.fillRectangle(getXPos(), getYPos(), (int) width, (int) length);
	}
	
	@Override
	public boolean select(int x, int y) {
		org.eclipse.swt.graphics.Rectangle r = new org.eclipse.swt.graphics.Rectangle(xPos, yPos, xPos + (int) width, yPos + (int) length);
		return r.contains(x, y);
	}
	
	public void move(int panelWidth, int panelHeight)
	{
		if (!isMovable())
			return;
		
		xPos += dx;
        yPos += dy;
       
        
        
        if (xPos < 0)
        {
            xPos = 0;
            dx = -dx;
        }

        if (xPos + width >= panelWidth)
        {
            xPos = (int) ((double)panelWidth - width);
            dx = -dx;
        }

        if (yPos < 0)
        {
            yPos = 0;
            dy = -dy;
        }

        if (yPos + length >= panelHeight)
        {
            yPos = (int) (panelHeight - length);
            dy = -dy;
        }
	}
}