import java.io.Serializable;

public class Observer implements  Serializable {
	
	public Observer(){
		
	}
	
	public void update(Account cont){
		System.out.println("Contul cu numarul " + cont.getId() + " are soldul=" + cont.getSum() );
	}
}
