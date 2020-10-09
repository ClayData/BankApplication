package accounts;

public class SalaryAccount implements Actions {

	private int balance;
	private int minBalance = 500;
	
	public SalaryAccount(int initial, int salary, int age) throws BelowMinBalanceException, BelowMinSalaryException, BelowMinAgeException {
		if(initial < minBalance) {
			throw new BelowMinBalanceException("Current Account balance should be $500");
		}
		if(salary < 5000) {
			throw new BelowMinSalaryException("Salary is below the acceptable threshold");
		}
		if(age < 23) {
			throw new BelowMinAgeException("Must be over 23 years old to open account");
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
