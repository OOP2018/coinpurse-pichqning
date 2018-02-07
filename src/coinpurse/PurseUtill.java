package coinpurse;

/**
 * This class is the class for testing Purse class.
 * @author Pichaaun Popukdee
 *
 */

public class PurseUtill {
	public static String CURR = "Bath";
	public static void main(String[] args) {
		Purse p = new Purse(6);
		p.insert(new BankNote(20 , CURR));
		p.insert(new BankNote(100, CURR));
		p.insert(new Coin(5, CURR));
		p.insert(new Coin(10, CURR));
		p.insert(new BankNote(1000, CURR));
		p.insert(new Coin(2, CURR));
		p.insert(new Coin(1, CURR));
		System.out.println("Purse contain: " + p.count());
		System.out.println("Purse is Full? " + p.isFull());
		System.out.println(p.toString());
		p.withdraw(1015);
		System.out.println("Withdrew...");
		System.out.println(p.toString());
		
	}

}
