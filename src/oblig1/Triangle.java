/**
 * 
 */
package oblig1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import org.eclipse.swt.graphics.GC;

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
		super( 0, 0, true, Color.blue, 300, 300);
		height = l;
		width = w;
	}
	public Triangle(int x, int y, boolean f, Color c,int panelWidth, int panelHeight, int width, int height) {
		xPos = x;
		yPos = y;
		filled = f;
		color = c;
		this.panelHeight = panelHeight;
		this.panelWidth = panelWidth;
		this.width = width;
		this.height = height;
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
	public void draw(GC g) {
		Polygon p = new Polygon();
		p.addPoint(getXPos(), getYPos());
		p.addPoint(getXPos() + (int) width, getYPos());
		p.addPoint(getXPos() + (int) width/2, getYPos() + (int) height);
		
		int x = getXPos();
		int y = getYPos() + (int) height;
		int[] a = {x, y, x + (int) width / 2, y - (int) height, x + (int) width, y};
		g.drawPolyline(a);
		g.drawLine(x, y, x + (int) width, y);
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

        if (yPos + height >= panelHeight)
        {
            yPos = (int) (panelHeight - height);
            dy = -dy;
        }
	}
}