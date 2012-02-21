package oblig2.oppg2;

//***************************************** 
//Cylinder.java
//
//Represents a cylinder.
//***************************************** 
public class Cylinder extends Shape 
{
  private double radius;  //radius in feet
  private double height;  // height in feet
  //---------------------------------- 
  //Constructor: Sets up the cylinder. 
  //---------------------------------- 
  public Cylinder(double r, double h) 
  {
    super("Cylinder"); 
    radius = r;
    height = h;
  } 
  //----------------------------------------- 
  //Returns the surface area of the cylinder. 
  //----------------------------------------- 
  public double area() 
  {
    return Math.PI*radius*radius*height;
  }
  //----------------------------------- 
  //Returns the cylinder as a String. 
  //----------------------------------- 
  public String toString() 
  {
    return super.toString() + " of radius " + radius + " and height " + height;
  }
}
