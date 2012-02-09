/**
 * 
 */
package oblig1;

/**
 * @author runar
 * 
 */
// GeoObject.java:
public abstract class GeoObject {
	private String color = "white";
	private boolean filled;
	private int xPos;
	private int yPos;

	// Default constructor
	protected GeoObject() {
	}

	// Lag et geo object*/
	protected GeoObject(int x, int y, boolean f, String c) {
		xPos = x;
		yPos = y;
		filled = f;
		color = c;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
}