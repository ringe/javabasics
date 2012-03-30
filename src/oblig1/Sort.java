/**
 * 
 */
package oblig1;

/**
 * @author runar
 *
 */
public class Sort {
    public static void selectionSort(Comparable a [], int n) {

      Comparable temp;
      int chosen;

      for (int leftmost = 0; leftmost < n-1; leftmost++) {
        chosen = leftmost;
        for (int j = leftmost+1; j < n; j++)
          if (a[j].compareTo(a[chosen]) < 0) chosen = j;
          temp = a[chosen];
          a[chosen] = a[leftmost];
          a[leftmost] = temp;
      }
    }
}
