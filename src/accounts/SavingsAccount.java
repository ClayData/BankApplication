package accounts;

public class SavingsAccount implements Actions{

	private int balance;
	private int minBalance = 1000;
	
	public SavingsAccount(int initial, int age) throws BelowMinBalanceException, BelowMinAgeException {
		if(initial < minBalance) {
			throw new BelowMinBalanceException("Current Account balance should be $1000");
		}
		if(age < 18) {
			throw new BelowMinAgeException("Must be over 18 years old to open Savings Account");
		}
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public void transferFunds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(int amount) {
		this.balance -= amount;
		
	}

	@Override
	public void deposit(int amount) {
		this.balance += amount;
		
	}

	@Override
	public int getStatement() {
		// TODO Auto-generated method stub
		return 0;
	}

}
