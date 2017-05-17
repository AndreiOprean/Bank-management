import java.io.Serializable;

public class Person implements Serializable {
	
	
	private String nume;
	private String eMail;
	private int varsta;
	
	public Person( String nume, String eMail, int varsta){
		
		this.nume = nume;
		this.eMail = eMail;
		this.varsta = varsta;
	}
	

	
	public String getNume(){
		return nume;
	}
	
	public void setNume(String nume){
		this.nume = nume;
	}
	
	public String getMail(){
		return eMail;
	}
	
	public void setMail(String eMail){
		this.eMail = eMail;
	}
	
	public int getVarsta(){
		return varsta;
	}
	
	public void setVarsta(int varsta){
		this.varsta = varsta;
	}
}
