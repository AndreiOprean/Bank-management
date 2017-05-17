public class SpendingAccount extends Account {
	
	private int sumSpending;
	private Observer o;
	
	public SpendingAccount(int id, Person p, int sumSpending){
		super(id,p,"Spending Account",sumSpending);
		this.sumSpending = sumSpending;
		o = new Observer();
	}
	
	public int getSum(){
		return sumSpending;
	}
	
	public void setSum(int s){
		this.sumSpending = s;
	}
	
	
	
	public String addSum(int sum){
	if (sum > 0){
		this.sumSpending = this.sumSpending + sum;
		o.update(this);
		return null;
		}
	else{
		return("Depozitare esuata");
	}
	}
	
	public String removeSum(int sum){
		if (this.sumSpending > sum){
			this.sumSpending = this.sumSpending - sum;
			o.update(this);
			return null;
		}
		else{
			return ("Retragere esuata");
		}
	}
	
	
	
	
}
