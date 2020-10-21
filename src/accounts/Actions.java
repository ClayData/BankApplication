package accounts;

import java.util.ArrayList;

public interface Actions {

	void transferFunds();
	
	void withdraw(int amount) throws BelowMinBalanceException;
	
	void deposit(int amount); 
	
	ArrayList<Integer> getStatement();
}
