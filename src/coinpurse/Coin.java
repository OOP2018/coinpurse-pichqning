package coinpurse;

/**
 * 
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Pichaaun Popukdee
 * 
 *
 */
public class Coin extends Money{
	
	public Coin ( double value , String currency ) {
		super (value,currency);
	}

	@Override
	public String toString () {
		return String.format("%.2f-%s", this.getValue(), this.getCurrency());
	}
	
	
	
	
	
	

}
