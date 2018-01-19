package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
	
	public static void sortCoins (List<Coin> coins) {
		java.util.Collections.sort( coins );
		
	}
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
    	coins.add( new Coin (10.0,"Baht"));
    	coins.add( new Coin (0.5,"Baht"));
    	coins.add( new Coin (2.0,"Baht"));
    	coins.add( new Coin (1.0,"Baht"));
    	printCoins ( coins ) ;
    	sortCoins ( coins );
    	printCoins ( coins ) ;
	}
	 public static void printCoins (List<Coin> coins) {
	    	System.out.println(coins);
	    }
}
