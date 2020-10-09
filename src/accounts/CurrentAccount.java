package accounts;

public class CurrentAccount implements Actions {

	private int balance;
	private int minBalance = 1500;
	
	public CurrentAccount(int initial, int salary, int age) throws BelowMinBalanceException, BelowMinAgeException, BelowMinSalaryException {
		if(initial < minBalance) {
			throw new BelowMinBalanceException("Current Account balance should be $1500");
		}
		if(salary < 5000) {
			throw new BelowMinSalaryException("Salary is below the acceptable threshold");
		}
		if(age < 25) {
			throw new BelowMinAgeException("Must be over 25 years old to open Savings Account");
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
