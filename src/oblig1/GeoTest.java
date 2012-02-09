/**
 * 
 */
package oblig1;

/**
 * @author runar
 *
 */
public class GeoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Circle c = new Circle();
		System.out.println(r);
		System.out.println(c);
		r = new Rectangle(2, 3);
		c = new Circle(3);
		System.out.println(r);
		System.out.println(c);
	}

}
