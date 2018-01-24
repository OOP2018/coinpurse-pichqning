package coinpurse;

/**
 * this is the class that has for testing Coin class.
 * 
 * @author Pichaaun Popukdee.
 */

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
	
	/**
	 * This is for sort the coin from the smallest to biggest.**/
	public static void sortCoins (List<Coin> coins) {
		java.util.Collections.sort( coins );
		
	}
	
	/**
	 * This method is use for sort the coin which are the same currency.
	 * @param coins (Contain value and currency of the coins).
	 * @param currency (Currency that want to sort by).
	 * @return the list of the coin that already sort by the currency.
	 */
	public static List<Coin> filterByCurrency (List<Coin> coins , String currency){
		List<Coin> sortCurr = new ArrayList<Coin>();
		for (Coin i : coins) {
			if(i.getCurrency().toLowerCase().equals(currency.toLowerCase())) {
				sortCurr.add(i);
			}
		}
		return sortCurr ;
	}
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
    	coins.add( new Coin (10.0,"Baht"));
    	coins.add( new Coin (0.5,"Baht"));
    	coins.add( new Coin (20,"Dollar"));
    	coins.add( new Coin (500,"Won"));
    	coins.add( new Coin (2.0,"Baht"));
    	coins.add( new Coin (15,"Dollar"));
    	coins.add( new Coin (1.0,"Baht"));
    	coins.add( new Coin (100,"Won"));
    	printCoins ( coins ) ;
    	sortCoins ( coins );
    	printCoins ( coins ) ;
    	
    	List<Coin> testFilbyCur = filterByCurrency(coins,"Baht");
    	System.out.println("Sort by currency : " + testFilbyCur);
	}
	/**This method is the method for print all of coins.**/
	 public static void printCoins (List<Coin> coins) {
	    	System.out.println(coins);
	    }
}
