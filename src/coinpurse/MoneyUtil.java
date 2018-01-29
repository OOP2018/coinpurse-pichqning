package coinpurse;

/**
 * this is the class that has for testing Coin class.
 * 
 * @author Pichaaun Popukdee.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoneyUtil {
	
	/**
	 * This is for sort the coin from the smallest to biggest.
	 * **/
	public static void sortCoins (List<Valuable> valuable) {
		Comparator<Valuable> comp = new ValueComparator();
		valuable.sort(comp);
	}
	
	/**
	 * This method is use for sort the coin which are the same currency.
	 * @param coins (Contain value and currency of the coins).
	 * @param currency (Currency that want to sort by).
	 * @return the list of the coin that already sort by the currency.
	 */
	public static List<Valuable> filterByCurrency (List<Valuable> coins , String currency){
		List<Valuable> sortCurr = new ArrayList<Valuable>();
		for (Valuable i : coins) {
			if(i.getCurrency().toLowerCase().equals(currency.toLowerCase())) {
				sortCurr.add(i);
			}
		}
		return sortCurr ;
	}
	public static void main(String[] args) {
		List<Valuable> valuable = new ArrayList<Valuable>();
    	valuable.add( new Coin (10.0,"Baht"));
    	valuable.add( new Coin (0.5,"Baht"));
    	valuable.add( new Coin (20,"Dollar"));
    	valuable.add( new Coin (2.0,"Baht"));
    	valuable.add( new Coin (15,"Dollar"));
    	valuable.add( new Coin (1.0,"Baht"));
 
    	printCoins ( valuable ) ;
    	sortCoins ( valuable );
    	printCoins ( valuable ) ;
    	
    	List<Valuable> testFilbyCur = filterByCurrency(valuable,"Baht");
    	System.out.println("Sort by currency : " + testFilbyCur);
	}
	/**This method is the method for print all of coins.**/
	 public static void printCoins (List<Valuable> coins) {
	    	System.out.println(coins);
	    }
}
