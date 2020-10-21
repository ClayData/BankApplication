package accounts;

import java.util.ArrayList;

import database.AddAccount;
import database.BalanceCheck;

public class SalaryAccount implements Actions {

	private int balance;
	private int minBalance = 500;
	ArrayList<Integer> statement = new ArrayList<>();
	
	public SalaryAccount(int initial, int salary, int age, int cust_id) throws BelowMinBalanceException, BelowMinSalaryException, BelowMinAgeException {
		
		if(initial < minBalance) {
			throw new BelowMinBalanceException("Current Account balance should be $500");
		}
		if(salary < 5000) {
			throw new BelowMinSalaryException("Salary is below the acceptable threshold");
		}
		if(age < 23) {
			throw new BelowMinAgeException("Must be over 23 years old to open account");
		}
		AddAccount aa = new AddAccount();
		aa.openAnAccount("salary_account", cust_id, initial);
	}
	
	public int getBalance() {
		BalanceCheck bc = new BalanceCheck();
		balance = bc.checkBalance("current_account");
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
	public synchronized void withdraw(int amount) {
		if((balance - amount) < minBalance) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
		balance = balance - amount;
		this.statement.add(balance);
		}
		
	}

	@Override
	public synchronized void deposit(int amount) {
		balance = balance + amount;
		this.statement.add(balance);
		notify();
	}

	@Override
	public ArrayList<Integer> getStatement() {
		// TODO Auto-generated method stub
		return this.statement;
	}
	
}
