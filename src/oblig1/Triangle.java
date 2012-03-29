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
		return (height * width) / 2;
	}

	/* (non-Javadoc)
	 * @see oblig1.GeoObject#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		// TOOD
		return 0.0;
	}

	public String toString() {
		return "Triangle: " + height + "w, " + width + "h, " + getArea() + " area and " + getPerimeter() + " around. " + getColor() + " x: " + getXPos() + " y: " + getYPos(); 
	}
	
	private int[] points() {
		int x = xPos;
		int y = yPos + (int) height;
		int[] a = {x, y, x + (int) width / 2, y - (int) height, x + (int) width, y};
		return a; 
	}
	
	@Override
	public boolean select(int x, int y) {
		int[] p = points();
		Polygon po = new Polygon();
		po.addPoint(p[0], p[1]);
		po.addPoint(p[2], p[3]);
		po.addPoint(p[4], p[5]);
		return po.contains(x, y);
	}

	@Override
	public void draw(GC g) {
		g.drawPolyline(points());
		g.drawLine(xPos, yPos  + (int) height, xPos + (int) width, yPos + (int) height);
	}
	
	public void move()
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

        if (yPos + height >= panelHeight)
        {
            yPos = (int) (panelHeight - height);
            dy = -dy;
        }
	}
}