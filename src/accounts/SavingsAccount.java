package accounts;

import java.util.ArrayList;
import database.AddAccount;
import database.BalanceCheck;

public class SavingsAccount implements Actions{

	private int balance;
	private int minBalance = 1000;
	ArrayList<Integer> statement = new ArrayList<>();
	
	public SavingsAccount() {
		
	};
	
	public SavingsAccount(int initial, int age, int cust_id) throws BelowMinBalanceException, BelowMinAgeException {
		if(initial < minBalance) {
			throw new BelowMinBalanceException("Current Account balance should be $1000");
		}
		if(age < 18) {
			throw new BelowMinAgeException("Must be over 18 years old to open Savings Account");
		}
		AddAccount aa = new AddAccount();
		aa.openAnAccount("savings_account", cust_id, initial);
	}
	
	public int getBalance() {
		BalanceCheck bc = new BalanceCheck();
		balance = bc.checkBalance("current_account");
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
		this.statement.add(balance);
	}

	@Override
	public void transferFunds() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized void withdraw(int amount) {
		if((balance - amount) < minBalance) {
			try {
				System.out.println("Insufficient Balance ");
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
	public void deposit(int amount) {
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
