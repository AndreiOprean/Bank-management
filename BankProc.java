
public interface BankProc {
	
	/*
	 * @pre a != null
	 * @pre a.id > 0;
	 * 
	 */
	public void addAccount(Account a);
	
	/*
	 * 
	 * @pre a != null
	 * 
	 */
	
	public void deleteAccount(Account a);
	
	/*
	 * @pre n > 0
	 * @post return != null
	 */
	
	public Account getAccount(int n);
}
