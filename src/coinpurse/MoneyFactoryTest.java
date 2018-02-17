package coinpurse;
import static junit.framework.TestCase.assertEquals;
import org.junit.*;
/**
 * 
 * TestCases for MoneyFactory class.
 * @author Pichaaun Popukdee
 *
 */
public class MoneyFactoryTest {

	@Test
	public void testSingleton() {
		MoneyFactory a = MoneyFactory.getInstance();     
		MoneyFactory b = MoneyFactory.getInstance();
		assertEquals(true, a==b);
	}
	
	@Test
	public void testThaiCreated() {
		MoneyFactory m = new ThaiMoneyFactory();
		assertEquals(1000.0,m.createMoney(1000).getValue());
		assertEquals(100.0,m.createMoney(100).getValue());
		assertEquals(50.0,m.createMoney("50").getValue());
		assertEquals(10.0,m.createMoney("10").getValue());
		assertEquals(0.25,m.createMoney("0.25").getValue());
		assertEquals("Baht" , m.createMoney("5").getCurrency());
		assertEquals("Baht" , m.createMoney(100).getCurrency());
	}
	
	@Test
	public void testMalayCreated() {
		MoneyFactory m = new MalayMoneyFactory();
		assertEquals(100.0,m.createMoney(100).getValue());
		assertEquals(20.0,m.createMoney(20).getValue());
		assertEquals(50.0,m.createMoney("50").getValue());
		assertEquals(10.0,m.createMoney("10").getValue());
		assertEquals(0.20,m.createMoney("0.20").getValue());
		assertEquals("Ringgit" , m.createMoney("50").getCurrency());
		assertEquals("Sen",m.createMoney(0.05).getCurrency());
	}

	@Test
	public void testSetFactory() {
    MoneyFactory factory_TH = MoneyFactory.getInstance();
    assertEquals(ThaiMoneyFactory.getInstance(),factory_TH);
    MoneyFactory.setFactory(new MalayMoneyFactory());
    MoneyFactory factory_MA = MoneyFactory.getInstance();
    assertEquals(MalayMoneyFactory.getInstance().getClass(),factory_MA.getClass());
	}

}
