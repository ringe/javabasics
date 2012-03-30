/**
 * 
 */
package oblig1;


import org.eclipse.swt.graphics.Color;
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
		g.setBackground(color);
		g.fillOval(getXPos(), getYPos(), (int) radius, (int) radius);
	}
	
	@Override
	public boolean select(int x, int y) {
		if ((Math.pow((x - xPos), 2) + Math.pow((y - yPos), 2)) < Math.pow(radius, 2))
			return true;
		return false;
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