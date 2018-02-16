package coinpurse;
/**
 * 
 * @author Pichaaun Popukdee
 *
 */

public class MoneyFactoryDemo {
	
	/**
	 * 
	 * @param factoryclass
	 */
	private static void setFactory(String factoryclass) {
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (IllegalArgumentException | InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
			throw new IllegalArgumentException("Factory is incorrect");
		}
	}
	
	/*
	 * 
	 */
	private static Money createMalay (double value) {
		if (value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) return new Coin(value, "Sen");
		else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) return new BankNote(value,"Ringgit");		
		else throw new IllegalArgumentException("Cannot create" + value + "Baht");
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private static Money createThai (double value) {
		if (value == 0.25 || value == 0.50 || value == 1 || value == 2 || value == 5 || value == 10 ) return new Coin(value,"Baht" );
		else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) return new BankNote(value,"Baht");		
		else throw new IllegalArgumentException("Fuck off this country!");
	}
	
	/**
	 * 
	 * @param testPrompt
	 * @param expected
	 * @param actual
	 */
	private static void testing(String testPrompt , Object expected , Object actual){
		System.out.println(testPrompt + " test");
		System.out.printf("Expected : %s , Actual: %s , Result: %s%n" , expected , actual , expected.equals(actual));
	}
	
	/**
	 *  
	 * @param amounts
	 */
	private static void testThaiMoney (double[] amounts) {
		setFactory("coinpurse.ThaiMoneyFactory");
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		System.out.println("Test create money");
		for (double value : amounts) {
			testing("Create" + value + "Baht" , moneyFactory.createMoney(value) , createMalay(value));
		}
		
	}
	}
