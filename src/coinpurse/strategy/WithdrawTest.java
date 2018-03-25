package coinpurse.strategy;

import coinpurse.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.*;


/**
 * Test for Withdraw Strategy by using Junit.
 * @author Pichaaun Popukdee
 *
 */

public class WithdrawTest {
    private WithdrawStrategy strategy;
    private MoneyFactory factory;
    private List<Valuable> purse;

    /**
     * Sets up the test fixture.
     * Called before every test method.
     */
    @Before
    public void setUp() {
        try {
            strategy = new RecursiveWithdraw();
            purse = new ArrayList<>();
            factory = MoneyFactory.getInstance();
        }
        catch (Exception e) {
            System.err.println("Cannot initialize.");
        }
    }

    @Before
    public void init() {
        purse.clear();
    }
    public double getValue(List<Valuable> money) {
        double total = 0;
        for (Valuable m : money){
            total += m.getValue();
        }
        return total;
    }

    @Test
    public void testEasyWithdraw() {
        double [] values = {1, 20, 0.5, 10}; // values of coins we will insert
        for(double value : values) {
            Valuable coin = factory.createMoney(value);
            assertTrue(purse.add(coin));
        }
            List<Valuable> result = strategy.withdraw(new Money(31 , "Baht"),purse);
            assertTrue(result!=null);
        }



    /** Withdraw full amount in purse, using varying numbers of objects. */
    @Test
    public void testWithdrawEverything() {
        // Coins we want to insert and then withdraw.
        // Use values such that greedy will succeed, but not monotonic
        List<Valuable> coins = Arrays.asList(
                factory.createMoney(1.0), factory.createMoney(0.5), factory.createMoney(10.0), factory.createMoney(0.25), factory.createMoney(5.0)
        );
        // num = number of coins to insert and then withdraw
        for(int num=1; num <= coins.size(); num++) {
            double amount = 0.0;
            for(Valuable c: coins) {
                purse.add(c);
                amount += c.getValue();
            }
            // can we withdraw it all?
            List<Valuable> result = strategy.withdraw(new Money(amount,"Baht") , purse);
            // assertEquals(getValue(result) ,amount);
            // should not be anything left in the purse
            assertEquals( amount, getValue(result));
        }
    }


    @Test
    public void testImpossibleWithdraw() {
        assertNull(strategy.withdraw(factory.createMoney(1),purse));
    }

    @Test
    public void testWithdrawExceptOne () {
        double [] values = {1, 20, 0.5, 10}; // values of coins we will insert

        for(double value : values) {
            purse.add( factory.createMoney(value));
        }
        List<Valuable> result = strategy.withdraw(new Money(31,"Baht") , purse );
        assertEquals(3,result.size());
    }

    @Test
    public void testWrongCurrency () {
        double [] values = {1, 20, 0.5}; // values of coins we will insert

        for(double value : values) {
            Valuable coin = factory.createMoney(value);
            assertTrue(purse.add(coin));
        }

        double [] values1 = {1, 10}; // values of coins we will insert

        for(double value : values1) {
            Valuable coin = factory.createMoney(value);
            assertTrue(purse.add(coin));
        }
        if (strategy.equals(new GreedyWithdraw())) {
            assertNull(strategy.withdraw(factory.createMoney(20),purse));
            assertNull(strategy.withdraw(factory.createMoney(10),purse));
        }
        else if (strategy.equals(new RecursiveWithdraw())) {
            assertEquals(strategy.withdraw(factory.createMoney(20), purse), new ArrayList<>());
            assertEquals(strategy.withdraw(factory.createMoney(10), purse), new ArrayList<>());
        }

    }

    @Test
    public void testMoreTotalWithdraw () {
        purse.add( factory.createMoney(20) );
        assertNull(strategy.withdraw(factory.createMoney(50),purse) );
    }

}
