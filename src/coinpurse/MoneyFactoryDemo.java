package coinpurse;
/**
 * 
 * 
 * @author Pichaaun Popukdee
 *
 */

public class MoneyFactoryDemo {

	public static void main(String[] args) {
		
		/*
		 * set factory to ThaiMoneyFactory currency is Baht.
		 */
	MoneyFactory.setFactory(new ThaiMoneyFactory());
	MoneyFactory factory = MoneyFactory.getInstance();
	Valuable money = factory.createMoney(10.0);
	System.out.println(money.toString());
	
	Valuable money1 = factory.createMoney("100.0");
	System.out.println(money1.toString());
	
	/*
	 * set factory to MalayMoneyFactory currency is Ringgit and sen.
	 */
	MoneyFactory.setFactory(new MalayMoneyFactory());
	MoneyFactory factoryMalay = MoneyFactory.getInstance();
	
	Valuable money2 = factoryMalay.createMoney(0.10);
	System.out.println(money2.toString());
	
	Valuable money3 = factoryMalay.createMoney("100.0");
	System.out.println(money3.toString());
	
	Valuable money4 = factoryMalay.createMoney("5.0");
	System.out.println(money4.toString());
	
	

}}