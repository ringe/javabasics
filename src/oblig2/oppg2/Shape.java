package oblig2.oppg2;
//***************************************** 
//Shape.java
//
//Represents a shape.
//*****************************************
public abstract class Shape {
  String shapeName;
  //---------------------------------- 
  //Constructor: Sets up the shape. 
  //----------------------------------
  public Shape(String name) {
    shapeName = name;
  }
  //----------------------------------------- 
  //Returns the surface area of the shape. 
  //-----------------------------------------
  public abstract double area();
  //----------------------------------- 
  //Returns the shape as a String. 
  //-----------------------------------
  public String toString() {
    return shapeName;
  }
}
