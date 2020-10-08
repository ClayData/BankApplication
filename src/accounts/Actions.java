package accounts;

public interface Actions {

	void transferFunds();
	
	void withdraw(int amount);
	
	void deposit(int amount); 
	
	int getStatement();
}
