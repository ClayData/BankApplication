package accounts;

import java.util.ArrayList;

public interface Actions {

	void transferFunds(int amount, int cust_id,  String from, String to);
	
	void withdraw(int amount, int cust_id) throws BelowMinBalanceException;
	 
	ArrayList<Integer> getStatement();

	void deposit(int amount, int cust_id);
}
