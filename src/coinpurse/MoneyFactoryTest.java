package coinpurse;
import static junit.framework.TestCase.assertEquals;
import org.junit.*;

public class MoneyFactoryTest {

	@Test
	public void testSingleton() {
		MoneyFactory a = MoneyFactory.getInstance();
		MoneyFactory b = MoneyFactory.getInstance();
		assertEquals(true, a==b);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testThaiCreated() {
		MoneyFactory m = new ThaiMoneyFactory();
		assertEquals(1000.0,m.createMoney(1000).getValue());
		assertEquals(100.0,m.createMoney(100).getValue());
		assertEquals(50.0,m.createMoney("50").getValue());
		assertEquals(10.0,m.createMoney("10").getValue());
		assertEquals(0.25,m.createMoney("0.25").getValue());
	}
}
