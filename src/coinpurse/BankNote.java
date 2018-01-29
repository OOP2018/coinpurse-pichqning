package coinpurse;
/**
 * 
 * Banknote represents money with a fixed value and currency.
 * 
 * @author Pichaaun Popukdee
 *
 *
 */

public class BankNote implements Valuable{
	
	/**
	 * next serial number of next banknote.
	 */
	private long nextSerialNumber = 1000000;
	
	/**
	 * Value of the banknote.
	 */
	private double value;
	
	/**
	 * Currency of the banknote.
	 */
	private String currency;
	
	/**
	 * Serial number of each banknote.
	 * (Every banknote has differnt serial number)
	 */
	private long serialNumber;
	
	/**
	 * Get the value of the banknote
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Get the currency of the banknote.
	 * @return currncy
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Get the serial number of each banknote
	 * @return serialNumber
	 */
	public long getSerial() {
		return serialNumber;
	}


	public BankNote (double value , String currency ) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber+1;
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
	        BankNote other = (BankNote)obj;
	        return this.currency.equals(other.currency) && this.value == other.value ;
	}
	
	@Override
	public String toString() {
		return String.format("%.0f-%s note [%d]", value , currency , serialNumber);
	}
	
	
	
	
}
