package coinpurse;

/**
 * 
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Pichaaun Popukdee
 * 
 *
 */
public class Coin implements Valuable {
	
	/**value of the coin.*/
	private double value;
	
	/**currency of the coin.*/
	private String currency;
	
	/**get the value of the coin.*/
	public double getValue() {
		return value;
	}

	/**get the currency of the coin.*/
	public String getCurrency() {
		return currency;
	}

	
	public Coin ( double value , String currency ) {
		this.value = value;
		this.currency = currency;
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
	        Coin other = (Coin)obj;
	        return this.currency.equals(other.currency) && this.value == other.value ;
	}
	
	
	@Override
	public String toString () {
		return String.format("%.2f-%s", value, currency);
	}
	
	
	
	
	
	

}
