package banking;

import java.util.Scanner;

import accounts.BelowMinAgeException;
import accounts.BelowMinBalanceException;
import accounts.BelowMinSalaryException;
import accounts.CurrentAccount;
import accounts.SalaryAccount;
import accounts.SavingsAccount;
import database.AddUser;
import database.AddAccount;
import database.CustRetriever;

public class BankApplication {
	
	CustRetriever cs = new CustRetriever();
	Scanner sc = new Scanner(System.in);
	
	public void addUser() {
		System.out.println("Enter customer name: ");
		String name = sc.next();
		System.out.println("Enter customer gender: ");
		String gender = sc.next();
		System.out.println("Enter customer salary: ");
		int salary = sc.nextInt();
		System.out.println("Enter customer email: ");
		String contact = sc.next();
		System.out.println("What is the age of the owner of the account");
		int age = sc.nextInt();
		AddUser au = new AddUser();
		au.addCustomer(name, gender, salary, contact, age);
		bankRunner();
	}
	
	public void openAccount() throws BelowMinBalanceException, BelowMinSalaryException, BelowMinAgeException {
		System.out.println("What type of account would you like to open");
		System.out.println("Press 1 for Savings");
		System.out.println("Press 2 for Salary");
		System.out.println("Press 3 for Current");
		int acct_type = sc.nextInt();
		System.out.println("How much would you like to deposit?");
		int deposit = sc.nextInt();

		System.out.println("What is the contact of the customer for the account");
		String name = sc.next();
		int cust_id = cs.retrieveCust(name);
		if(acct_type == 1) {
			try {
				int age = cs.retrieveAge(name);
				SavingsAccount sav = new SavingsAccount(deposit, age, cust_id);
			} catch (BelowMinBalanceException e) {
				e.printStackTrace();
			} catch (BelowMinAgeException e) {
				e.printStackTrace();
			}
		} else if (acct_type == 2) {
			
			int age = cs.retrieveAge(name);
			int salary = cs.retrieveSalary(name);
			SalaryAccount sal = new SalaryAccount(deposit, salary, age, cust_id);
		} else if (acct_type == 3) {
			
			int age = cs.retrieveAge(name);
			int salary = cs.retrieveSalary(name);
			CurrentAccount cur = new CurrentAccount(deposit, salary, age, cust_id);
		}
		bankRunner();
	};
	
	public void depositToAccount() {
		System.out.println("Which account would you like to deposit to?");
		System.out.println("Press 1 for Savings");
		System.out.println("Press 2 for Salary");
		System.out.println("Press 3 for Current");
		int choice = sc.nextInt();
		System.out.println("Please enter how much you would like to deposit?");
		int amount = sc.nextInt();
		
		System.out.println("Please enter the customer contact for the transaction");
		String cust = sc.next();
		int cust_id = cs.retrieveCust(cust);
		if(choice == 1) {
			SavingsAccount sav = new SavingsAccount();
			sav.deposit(amount, cust_id);
		} else if (choice == 2) {
			SalaryAccount sal = new SalaryAccount();
			sal.deposit(amount, cust_id);
		} else if (choice == 3) {
			CurrentAccount cur = new CurrentAccount();
			cur.deposit(amount, cust_id);
		} else {
			System.out.println("You have entered wrong please try again");
			depositToAccount();
		}
		bankRunner();
	}
	
	public void withdrawFromAccount() {
		System.out.println("Which account would you like to withdraw from?");
		System.out.println("Press 1 for savings account?");
		System.out.println("Press 2 for salary account?");
		System.out.println("Press 3 for current account?");
		int choice = sc.nextInt();
		System.out.println("Please enter how much you would like to withdraw");
		int amount = sc.nextInt();
		
		System.out.println("Please enter the customer contact for the transaction");
		String cust = sc.next();
		int cust_id = cs.retrieveCust(cust);
		if (choice == 1) {
			SavingsAccount sav = new SavingsAccount();
			sav.withdraw(amount, cust_id);
		} else if (choice == 2) {
			SalaryAccount sal = new SalaryAccount();
			sal.withdraw(amount, cust_id);
		} else if (choice == 3) {
			CurrentAccount cur = new CurrentAccount();
			cur.withdraw(amount, cust_id);
		} else {
			System.out.println("You have entered wrong please try again");
			sc.close();
			withdrawFromAccount();
		}
		bankRunner();
	}
	
	public void transaction() {
		System.out.println("Which accounts would you like to transfer from and to?");
		System.out.println("Press 1 for savings to salary");
		System.out.println("Press 2 for savings to current");
		System.out.println("Press 3 for salary to savings");
		System.out.println("Press 4 for salary to current");
		System.out.println("Press 5 for current to savings");
		System.out.println("Press 6 for current to salary");
		int choice = sc.nextInt();
		System.out.println("Please enter how much you would like to transfer?");
		int amount = sc.nextInt();
		System.out.println("Please enter the customer contact for the transaction");
		String cust = sc.next();
		int cust_id = cs.retrieveCust(cust);
		if (choice == 1) {
			SavingsAccount sav = new SavingsAccount(); 
			sav.transferFunds(amount, cust_id, "savings_account", "salary_account");
		} else if (choice == 2) {
			SavingsAccount sav = new SavingsAccount(); 
			sav.transferFunds(amount, cust_id, "savings_account", "current_account");
		} else if (choice == 3) {
			SalaryAccount sal = new SalaryAccount();
			sal.transferFunds(amount, cust_id, "salary_account", "savings_account");
		} else if (choice == 4) {
			SalaryAccount sal = new SalaryAccount();
			sal.transferFunds(amount, cust_id, "salary_account", "current_account");
		} else if (choice == 5) {
			CurrentAccount cur = new CurrentAccount();
			cur.transferFunds(amount, cust_id, "current_account", "savings_account");
		} else if (choice == 6) {
			CurrentAccount cur = new CurrentAccount();
			cur.transferFunds(amount, cust_id, "current_account", "salary_account");
		} else {
			System.out.println("You have entered wrong please try again");
			sc.close();
			transaction();
		}
		bankRunner();
	}
		
		public void retrieveStatement() {
			System.out.println("Which account statement would you like to look at");
			System.out.println("Press 1 for Savings");
			System.out.println("Press 2 for Salary");
			System.out.println("Press 3 for Current");
			int acct_choice = sc.nextInt();
			System.out.println("Enter the contact for the customer?");
			String contact = sc.next();
			int cust_id = cs.retrieveCust(contact);
			if(acct_choice == 1) {
				SavingsAccount sav = new SavingsAccount();
				sav.getStatement(cust_id);
			} else if (acct_choice == 2) {
				SalaryAccount sal = new SalaryAccount();
				sal.getStatement(cust_id);
			} else if (acct_choice == 3) {
				CurrentAccount cur = new CurrentAccount();
				cur.getStatement(cust_id);
			}
			bankRunner();
		}
		
		public void bankRunner() {
			BankApplication ba = new BankApplication();
			
			System.out.println("What would you like to do:");
			System.out.println("Press 1 to add a customer");
			System.out.println("Press 2 to open a new account with a customer");
			System.out.println("Press 3 to make a transaction");
			System.out.println("Press 4 to get an account statement");
			System.out.println("Press 5 to close");
			int opening = sc.nextInt();
			int transaction;
			
			if(opening == 1) {
				ba.addUser();
			} else if (opening == 2) {
				try {
					ba.openAccount();
				} catch (BelowMinBalanceException e) {
					e.printStackTrace();
				} catch (BelowMinSalaryException e) {
					e.printStackTrace();
				} catch (BelowMinAgeException e) {
					e.printStackTrace();
				}
			} else if (opening == 3) {
				System.out.println("What type of transaction would you like to make?");
				System.out.println("Press 1 for deposit");
				System.out.println("Press 2 for withdrawal");
				System.out.println("Press 3 for transfer");
				transaction = sc.nextInt();
				if(transaction == 1) {
					ba.depositToAccount();
				} else if(transaction == 2) {
					ba.withdrawFromAccount();
				} else if (transaction == 3) {
					ba.transaction();
				}
			} else if (opening == 4) {
				ba.retrieveStatement();
			} else if (opening == 5) {
				sc.close();
			}
		}
		
		public static void main(String[] args) {
			BankApplication ba = new BankApplication();
			ba.bankRunner();
			}
		
	}

