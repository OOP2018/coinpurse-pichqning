package coinpurse;

/**
 * 
 * Money represents coinage (money) with a fixed value and currency.
 * @author Pichaaun Popukdee
 *
 */

public class Money implements Valuable {

	/**value of the money.*/
	private double value;
	/**currency of the money.*/
	private String currency;

	public Money( double value , String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**get the value of the money.*/
	public double getValue() {
		return this.value;
	}

	/**get the currency of the money.*/
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * This method test that Are each money is equals by value and currency. **/
	@Override
	public boolean equals(Object obj) {
		 if (obj == null) {
	            return false;
	        }
	        if (obj.getClass() != this.getClass()) {
	            return false;
	        }
	        Money other = (Money)obj;
	        return this.currency.equals(other.currency) && this.value == other.value ;
	}

	/***
	 * 
	 * @param o
	 * @return 1 show that this>o
	 * 			0 show that this=o
	 * 			-1 show that this<o
	 */
	public int compareTo(Valuable o) {
		return Double.compare(this.getValue(), o.getValue());
	}
}
