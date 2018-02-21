package coinpurse;

/**
 * This class represent the factory for create Malaysia money in Ringgit and Sen.
 * @author Pichaaun Popukdee.
 *
 */

public class MalayMoneyFactory extends MoneyFactory{

	/**
	 * Currency of Banknote in Malaysia.
	 */
	private final String MA_BANK = "Ringgit";
	
	/**
	 * Currency of Coin in Malaysia.
	 */
	private final String MA_COIN = "Sen";

	/**
	 * next serial number of next banknote.
	 */
	private static long nextSerialNumber = 1000000;
	

	/**
	 * Create new money.
	 * @return new Valuable.
	 */
	@Override
	public Valuable createMoney(double value) {
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) return new Coin(value, MA_COIN);
		else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) return new BankNote(value,MA_BANK,nextSerialNumber++);		
		else throw new IllegalArgumentException("cannot create the money.-");
	}
	

}
