import java.io.Serializable;

public class SavingAccount extends Account implements Serializable {

private int interest;
private int sumSaving;
private boolean dep,ret;
private Observer o;

	public SavingAccount(int id, Person p, int sumSaving,int interest){
		super(id,p,"Saving Account",sumSaving);
		this.interest = interest;
		this.sumSaving = sumSaving;
		this.dep = false;
		this.ret = false;
		o = new Observer();
	}
	
	public int getInterest(){
		return interest;
	}
	
	public int getSum(){
		return sumSaving;
	}
	
	
	
	public void setSum(int s){
		this.sumSaving = s;
	}
	
	public String addSum(int sum){
		if (sum > 0 && dep == false){
			this.sumSaving = this.sumSaving + sum + interest;
			dep = true;
			o.update(this);
			return null;
		}
		else {
			return ("Depozitare esuata");
		}
	}
	
	public String removeSum(int sum){
		if (this.sumSaving > sum && ret == false){
			this.sumSaving = this.sumSaving - sum;
			ret = true;
			o.update(this);
			return null;
		}
		else{
			return("Retragere esuata");
		}
	}
}
