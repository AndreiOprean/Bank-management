import java.io.Serializable;
import java.util.Hashtable;
public class Bank implements BankProc,Serializable{

	private Hashtable<Integer, Account> bazaDate;
	
	public Bank(){
		bazaDate = new Hashtable<Integer, Account>(100);
	}
	
	public Hashtable<Integer, Account> getBazaDate(){
		return bazaDate;
	}
	
	public void addAccount(Account a){
		assert a != null : "Exceptie";
		assert a.getId() > 0 : "Exceptie";
		bazaDate.put(a.getId(), a);
	}
	
	public void deleteAccount(Account a){
		assert a != null : "Exceptie";
		if (bazaDate.containsKey(a.getId()) == true){
			bazaDate.remove(a.getId());
		}
	}
	
	public Account getAccount(int n){
		
		assert n > 0 : "Exceptie";
		assert bazaDate.get(n) != null : "Exceptie";
		return (bazaDate.get(n));
	
	}
	
	
}
