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
	 * @return  1 show that a>b
	 * 			0 show that a=b
	 * 			-1 show that a<b
	 * 
	 */
	public int compare(Valuable a, Valuable b) {
		if (a.getCurrency().equals(b.getCurrency())) {
			if(a.getValue() == b.getValue()) return 0;
			else if (a.getValue() > b.getValue()) return 1;
			else return -1;
		}
		else {
			if (a.getCurrency().compareTo(b.getCurrency())>0) {
				return 1;
			}
			else return -1;
		}
		
	}

}
