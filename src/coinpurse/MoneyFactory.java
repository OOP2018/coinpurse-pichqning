package coinpurse;

/**
 * 
 * Main class of ThaiFactory and MalayFactory to create new money.
 * @author Pichaaun Popukdee
 *
 */

public abstract class MoneyFactory {
	
	/**
	 * singleton instance of MoneyFactory.
	 */
	private static MoneyFactory instance = null ;
	
	/**
	 * Set class that want to create money.
	 * @param f
	 */
	public static void setFactory(MoneyFactory f) {
		instance = f;
	}

	/**
	 * @return instance
	 */
	public static MoneyFactory getInstance() {
		return instance;
	}
	
	/**
	 * parse the string as a double and call other createMoney method.
	 * @param value
	 * @return
	 */
	public abstract Valuable createMoney(double value) ;
	
	/**
	 * 
	 * Creating new money if cannot create throw NumberFormatException.
	 * @param value
	 * @return createMoney in double value.
	 */
	public Valuable createMoney (String value) {
		try {
			return createMoney(Double.parseDouble(value));
		}
		catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Cannot create Money.");
		}
	}
	

	
}
