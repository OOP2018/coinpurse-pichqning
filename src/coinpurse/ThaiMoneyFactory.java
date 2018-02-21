package coinpurse;
/**
 * 
 * This class represent the factory for create Thai baht money. 
 * @author Pichaaun Popukdee
 *
 */

public class ThaiMoneyFactory extends MoneyFactory{

	/**
	 * Currency of money in Thailand.
	 */
	private final String TH_CUR = "Baht";

	/**
	 * next serial number of next banknote.
	 */
	private static long nextSerialNumber = 1000000;
	
	@Override
	/**
	 * Create new money.
	 * @return new Valuable.
	 */
	public Valuable createMoney(double value) {
		if (value == 0.25 || value == 0.50 || value == 1 || value == 2 || value == 5 || value == 10 ) return new Coin(value, TH_CUR);
		else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) return new BankNote(value,TH_CUR,nextSerialNumber++);		
		else throw new IllegalArgumentException("Cannot create the money");
	}
	

}
