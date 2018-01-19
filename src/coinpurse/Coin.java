package coinpurse;

/**
 * 
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Pichaaun Popukdee
 * 
 *
 */
public class Coin implements Comparable<Coin> {
	
	/**
	 * 
	 * @param value of the money.
	 * @param currency of the money.
	 * 
	 **/
	private double value;
	private String currency;
	
	public double getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

	
	public Coin ( double value , String currency ) {
		this.value = value;
		this.currency = currency;
	}

	@Override
	/**
	 * This method test that Are each money is equals by value and currency. **/
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
	
	/**
	 * This method is compare the value of the money that which onr is bigger or smaller.
	 * @param coin
	 * @return 0 or 1 or -1
	 * 0 is mean the value is equals
	 * 1 is mean a is biger than b
	 * -1 is mean a is smaller than b **/
	public int compareTo (Coin coin) {
		double a = this.getValue();
		double b = coin.getValue();
		
		if (a-b == 0) {
			return 0;
		}
		else if (a-b < 0) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	public String toString () {
		return String.format("%.2f-%s", value, currency);
	}
	
	
	
	
	
	

}
