package accounts;

import java.util.ArrayList;
import java.util.List;
import database.BalanceCheck;
import database.AddAccount;

public class CurrentAccount implements Actions {

	private int balance;
	private int minBalance = 1500;
	ArrayList<Integer> statement = new ArrayList<>();
	
	public CurrentAccount(int initial, int salary, int age, int cust_id) throws BelowMinBalanceException, BelowMinAgeException, BelowMinSalaryException {
		if(initial < minBalance) {
			throw new BelowMinBalanceException("Current Account balance should be $1500");
		}
		if(salary < 5000) {
			throw new BelowMinSalaryException("Salary is below the acceptable threshold");
		}
		if(age < 25) {
			throw new BelowMinAgeException("Must be over 25 years old to open Savings Account");
		}
		AddAccount aa = new AddAccount();
		aa.openAnAccount("current_account", cust_id, initial);
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
