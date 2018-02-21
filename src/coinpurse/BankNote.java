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


	public BankNote (double value , String currency , long serialNumber) {
		super (value,currency);
		this.serialNumber = serialNumber;
	}
	
	
	@Override
	public String toString() {
		return String.format("%.0f-%s note [%d]", this.getValue() , this.getCurrency() , serialNumber);
	}
	

	
}
