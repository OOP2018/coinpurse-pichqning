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
 *
 */

public class WithdrawTest {
    private WithdrawStrategy strategy;

    /** tolerance for comparing two double values */
    private static final double TOL = 1.0E-6;
    /**
     * Currency of money in Thailand.
     */
    private final String TH_CUR = "Baht";

    /**
     * Currency of Banknote in Malaysia.
     */
    private final String MA_BANK = "Ringgit";

    /**
     * Currency of Coin in Malaysia.
     */
    private final String MA_COIN = "Sen";


    /**
     * Sets up the test fixture.
     * Called before every test method.
     */
    @Before
    public void setUp() {
        try {
            strategy = new GreedyWithdraw();
        }
        catch (Exception e) {
            System.err.println("Cannot initialize.");
        }
    }

    public double getValue(List<Valuable> money) {
        double total = 0;
        for (Valuable m : money){
            total += m.getValue();
        }
        return total;
    }

    /** Make a coin with the default currency. To save typing "new Coin(...)" */
    private Valuable makeTH(double value) {
        return new Money(value,TH_CUR);
    }

    private Valuable makeMaBank(double value) {
        return new Money(value,MA_BANK);
    }

    private Valuable makeMaCoin (double value) {
        return new Money(value,MA_COIN);
    }
    /** Add one coin and remove it. */
    @Test
    public void testEasyWithdraw() {
       List<Valuable> money = new ArrayList<>();
        double [] values = {1, 20, 0.5, 10}; // values of coins we will insert
        for(double value : values) {
            Valuable coin = makeTH(value);
            assertTrue(money.add(coin));
            List<Valuable> result = strategy.withdraw(makeTH(value),money);
            assertTrue( result != null );
        }
    }


    /** Withdraw full amount in purse, using varying numbers of objects. */
    @Test
    public void testWithdrawEverything() {
       List<Valuable> money = new ArrayList<>();
        // Coins we want to insert and then withdraw.
        // Use values such that greedy will succeed, but not monotonic
        List<Valuable> coins = Arrays.asList(
                makeTH(1.0), makeTH(0.5), makeTH(10.0), makeTH(0.25), makeTH(5.0)
        );
        // num = number of coins to insert and then withdraw
        for(int num=1; num <= coins.size(); num++) {
            double amount = 0.0;
            List<Valuable> subList = coins.subList(0, num);
            for(Valuable c: subList) {
                money.add(c);
                amount += c.getValue();
            }
            // can we withdraw it all?
            List<Valuable> result = strategy.withdraw(makeTH(amount) , money);
            String errmsg = String.format("couldn't withdraw %.2f but money has %s",
                    amount, Arrays.toString(subList.toArray()) );
            assertNotNull( errmsg, result );
            // is the amount correct?
          //  assertEquals(getValue(result) ,amount);
            // should not be anything left in the purse
            assertEquals( 0.0, getValue(money), TOL);
        }
    }


    @Test
    public void testImpossibleWithdraw() {
        List<Valuable> money = new ArrayList<>();
        assertNull(strategy.withdraw(makeTH(1),money));
        money.add( makeTH(20) );
        assertNull(strategy.withdraw(makeTH(1) , money)) ;
        assertNull(strategy.withdraw(makeTH(1),money) );
        assertNull(strategy.withdraw(makeTH(21),money) );
    }

    @Test
    public void testWithdrawExceptOne () {
        List<Valuable> money = new ArrayList<>();
        double [] values = {1, 20, 0.5, 10}; // values of coins we will insert

        for(double value : values) {
            Valuable coin = makeTH(value);
            assertTrue(money.add(coin));
        }
            strategy.withdraw(makeTH(31) , money );
        assertEquals(money.size(),1);
        assertEquals(getValue(money),0.5);
    }

    @Test
    public void testWrongCurrency () {
        List<Valuable> money = new ArrayList<>();
        double [] values = {1, 20, 0.5}; // values of coins we will insert

        for(double value : values) {
            Valuable coin = makeTH(value);
            assertTrue(money.add(coin));
        }

        double [] values1 = {1, 10}; // values of coins we will insert

        for(double value : values1) {
            Valuable coin = makeMaBank(value);
            assertTrue(money.add(coin));
        }

        assertNull(strategy.withdraw(makeMaBank(20),money));
        assertNull(strategy.withdraw(makeTH(10),money));


    }

    @Test
    public void testMoreTotalWithdraw () {
        List<Valuable> money = new ArrayList<>();
        money.add( makeTH(20) );
        assertNull(strategy.withdraw(makeTH(50),money) );
    }

}
