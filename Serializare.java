import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializare {
	
	public void serializare(Bank bank, String fisier){
		try{
			FileOutputStream fOut = new FileOutputStream(fisier);
			ObjectOutputStream objOut = new ObjectOutputStream(fOut);
			objOut.writeObject(bank);
			objOut.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Bank deserializare(String fisier){
		Bank bank = null;
		try{
			FileInputStream fOut = new FileInputStream(fisier);
			ObjectInputStream objIn = new ObjectInputStream(fOut);
			bank = (Bank)objIn.readObject();
			objIn.close();
		}catch(IOException | ClassNotFoundException e1){
			e1.printStackTrace();
		}
		return bank;
	}
	
	
}
