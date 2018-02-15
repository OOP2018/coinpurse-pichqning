package coinpurse;
/**
 * An interface for objects having a monetary value and currency.
 *@author Pichaaun Popukdee
 */

public interface Valuable extends Comparable<Valuable> {
	/**
	 * Get the monetary value of this object.
	 * @return the value of this object
	 */
	double getValue() ;
	/**
	 * Get the monetary currency of this object.
	 * @return the currency of this object
	 */
	 String getCurrency();
	
	
	
}
