package coinpurse;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  A Valuable purse contains money.
 *  You can insert money, withdraw money, check the balance,
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
	 * Strategy to withdraw the valuable
	 */
	private WithdrawStrategy strategy;
	/**
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse( int capacity ) {
    	money = new ArrayList<>();
    	this.capacity = capacity;
    	setStrategy(new RecursiveWithdraw());
    	
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
    	else if (valuable.getValue() == 0) return false;
    	else if (valuable.getValue() > 0 ) {
    	money.add(valuable); 
    
        return true;
    }
    	return false;}
    
    public Valuable[] withdraw (Valuable amount) {
    	if(amount == null) return null;
        	if (amount.getValue()< 0 ){
        		return null;
        	}
    	    money.sort(comp);
		 	List<Valuable> templist = strategy.withdraw(amount,money);
    		if (templist.size() > 0) {
		 		for (Valuable value : templist) {
		 			money.remove(value);
				}
			}else return null;

        	Valuable [] moneyArray = new Valuable [templist.size()];
        	moneyArray = templist.toArray(moneyArray);
            return moneyArray;
        }
    
        /**  
         *  Withdraw the requested amount of money.
         *  Return an array of valuable withdrawn from purse,
         *  or return null if cannot withdraw the amount requested.
         *  @param amounts is the amount to withdraw
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


	public void setStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}
}
