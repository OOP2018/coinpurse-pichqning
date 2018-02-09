package coinpurse;
/**
 * 
 * Banknote represents money with a fixed value and currency.
 * 
 * @author Pichaaun Popukdee
 *
 *
 */

public class BankNote extends Money{
	
	/**
	 * next serial number of next banknote.
	 */
	private static long nextSerialNumber = 1000000;
	
	/**
	 * Serial number of each banknote.
	 * (Every banknote has differnt serial number)
	 */
	private long serialNumber;
	

	/**
	 * Get the serial number of each banknote
	 * @return serialNumber
	 */
	public long getSerial() {
		return serialNumber;
	}


	public BankNote (double value , String currency ) {
		super (value,currency);
		this.serialNumber = nextSerialNumber++;
	}
	
	
	@Override
	public String toString() {
		return String.format("%.0f-%s note [%d]", this.getValue() , this.getCurrency() , serialNumber);
	}
	
	
	
	
}
