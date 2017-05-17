import java.io.Serializable;

public abstract class Account implements Serializable {
	
	private int id;
	private Person persoana;
	private String tipCont;
	private int sum;
	public Account(int id, Person persoana,String tipCont,int sum){
		this.id = id;
		this.persoana = persoana;
		this.tipCont = tipCont;
		this.sum = sum;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public Person getPersoana(){
		return persoana;
	}
	
	public String getTip(){
		return tipCont;
	}
	
	public int getSum(){
		return sum;
	}
	
	public void setPersoana(Person p){
	
		persoana.setNume(p.getNume());
		persoana.setMail(p.getMail());
		persoana.setVarsta(p.getVarsta());
	}
	
	public abstract String addSum(int sum);
	public abstract String removeSum(int sum);
	
}
