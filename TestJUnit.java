
import org.junit.Test;
import static org.junit.Assert.*;
public class TestJUnit {
	private Bank banca;
	public TestJUnit(){
		banca = new Bank();
	}
	
	@Test
	public void testAddAccount(){
		banca.addAccount(new SpendingAccount(6,new Person("Tiberiu","tibi@mail,mail",56),500));
		Account c = banca.getAccount(6);
		assertNotNull(c);
		assertEquals(c.getSum(),500);
	}
	
	@Test
	public void testDeleteAccount(){
		banca.addAccount(new SpendingAccount(6,new Person("Tiberiu","tibi@mail,mail",56),500));
		banca.deleteAccount(banca.getBazaDate().get(6));
		assertNull(banca.getBazaDate().get(6));
	}
	
	
}
