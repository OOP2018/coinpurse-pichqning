package coinpurse;

/**
 * 
 * @author Pichaaun Popukdee
 *
 */

public abstract class MoneyFactory {
	
	/**
	 * sigleton instance of MoneyFactory.
	 */
	private static MoneyFactory instance = null ;
	
	/**
	 * 
	 * @param f
	 */
	public static void setFactory(MoneyFactory f) {
		instance = f;
	}

	/**
	 * 
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
	 * @param value
	 * @return
	 */
	public Valuable createMoney (String value) {
		try {
			return createMoney(Double.parseDouble(value));
		}
		catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Just drop this subject");
		}
	}
	

	
}
