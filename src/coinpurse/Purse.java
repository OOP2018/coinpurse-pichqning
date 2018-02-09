package coinpurse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  A Valuable purse contains with coins and banknotes.
 *  You can insert coins and banknotes, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Pichaaun Popukdee
 */
public class Purse {
	
	/**
	 * Comparator for valuables.
	 */
	private Comparator<Valuable> comp = new ValueComparator();
	
    /** Collection of objects in the purse. */
	List<Valuable> money ;
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse( int capacity ) {
    	money = new ArrayList<Valuable>();
    	this.capacity = capacity;
    	
    }

    /**
     * Count and return the number of items in the purse.
     * This is the number of items , not their value.
     * @return the number of items in the purse
     */
    public int count() { return money.size(); }
    
   
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double total = 0;
		for ( Valuable a : money ) {
		 total += a.getValue(); 
		 }
		return total;
		}
	

    
    /**
     * Return the capacity of the purse.
     * @return the capacity
     */
    
    public int getCapacity() { 
		return this.capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
		
		if (count() >= capacity) {
			return true;
		} else {
			return false;
		}
	}

    /** 
     * Insert a money into the purse.
     * The money is only inserted if the purse has space for it
     * and the money has positive value.  No worthless coins!
     * @param valuable is a Valuable object to insert into purse
     * @return true if money inserted, false if can't insert
     */
    public boolean insert( Valuable valuable ) {
    	if(isFull()) {
    		return false;
    	}
    	else if (valuable.getValue() > 0 ) {
    	money.add(valuable); 
    
        return true;
    }
    	return false;}
    
    public Valuable[] withdraw (Valuable amount) {
    	double amountNeededToWithdraw = amount.getValue();
        	if (amountNeededToWithdraw < 0 || this.getBalance() < amountNeededToWithdraw ) {
        		return null;
        	}
    		List<Valuable> templist = new ArrayList<>();
    	    money.sort(comp);	
    	
    		for (int k = money.size() - 1; k >= 0; k--) {
    			if (amountNeededToWithdraw >= 0) {
    			if (money.get(k).getCurrency().equalsIgnoreCase(amount.getCurrency())){ 
    				if (amountNeededToWithdraw == 0 ) break;
    				if (amountNeededToWithdraw - money.get(k).getValue() >= 0) {
    					amountNeededToWithdraw -= money.get(k).getValue();
    					templist.add(money.get(k));
    					money.remove(k);
    				} 
    			}else break;
    			}
    		}

        	Valuable [] moneyArray = new Valuable [templist.size()];
        	moneyArray = templist.toArray(moneyArray);
        	if ( moneyArray == null  ) return null;
        	if ( amountNeededToWithdraw > 0) {
        		money.addAll(templist);
        		return null;
        	}
            return moneyArray;
        }
    
        /**  
         *  Withdraw the requested amount of money.
         *  Return an array of valuable withdrawn from purse,
         *  or return null if cannot withdraw the amount requested.
         *  @param amountNeededToWithdraw is the amount to withdraw
         *  @return array of valuable objects for money withdrawn, 
    	 *    or null if cannot withdraw requested amount.
         */
        public Valuable[] withdraw( double amounts ) {	
           return withdraw(new Money(amounts,"Baht"));
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	
    	return String.format("%d valuable with value %.2f", count(),getBalance());
    }

    
}
