/**
 * 
 */
package oblig1;

/**
 * @author runar
 *
 */
public class Country implements Comparable<Country> {
	
	private String name;
	protected int population;

	public Country(String n, int p) {
		name = n;
		population = p;
	}
	
	@Override
	public int compareTo(Country o) {
		if (this.population < o.population) return -1;
		if (this.population > o.population) return 1;
		return 0;
	}

	public String toString() {
		return name;
	}
}
