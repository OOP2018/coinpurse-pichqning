package coinpurse;

import java.util.Comparator;

/**
 * 
 * Comparator for Valuable class.
 * @author Pichaaun Popukdee
 *
 */

public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Compare two objects that implement Valuable.
	 * First compare them by currency, so that "Baht" < "Dollar".
	 * If both objects have the same currency, order them by value.
	 * 
	 * @param a Valuable obj that we want to compare with other Valuable.
	 * @param b Valuable obj that we bring to compare with a
	 * @return negative integer if a less than b.
	 * zero if a equals b.
	 * positive integer if a more than b.
	 * 
	 */
	public int compare(Valuable a, Valuable b) {
		if (a.getCurrency().equals(b.getCurrency())) {
			return Double.compare(a.getValue(), b.getValue());
		}
		else return a.getCurrency().compareTo(b.getCurrency());

}
}
