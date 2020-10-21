package accounts;

public class AccountsUser extends Thread{

	SalaryAccount salary;
	CurrentAccount current;
	SavingsAccount savings;
	boolean bol;
	int amount;
	
	@Override
	public void run() {
		if(bol == true) {
			salary.deposit(amount);
		} else {
			salary.withdraw(amount);
		}
	}
	
	
	public AccountsUser(SalaryAccount salary, CurrentAccount current, SavingsAccount savings, boolean bol, int amount) {
		super();
		this.salary = salary;
		this.current = current;
		this.savings = savings;
		this.bol = bol;
		this.amount = amount;
	}


	public static void main(String[] args) throws BelowMinBalanceException, BelowMinSalaryException, BelowMinAgeException {
		// TODO Auto-generated method stub
		boolean credit=true, debit=false;
		SalaryAccount sal = new SalaryAccount(0, 55000, 30);
		CurrentAccount cur = new CurrentAccount(0, 55000, 30);
		SavingsAccount sav = new SavingsAccount(0, 30);
		
	}

}
