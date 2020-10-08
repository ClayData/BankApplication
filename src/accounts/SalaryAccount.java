package accounts;

public class SalaryAccount implements Actions {

	private int balance;
	
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
