package banking;

import java.util.Scanner;

import accounts.CurrentAccount;
import accounts.SalaryAccount;
import accounts.SavingsAccount;
import database.AddUser;
import database.AddAccount;
import database.CustRetriever;

public class BankApplication {
	
	CustRetriever cs = new CustRetriever();
	
	public void addUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer name: ");
		String name = sc.next();
		System.out.println("Enter customer gender: ");
		String gender = sc.next();
		System.out.println("Enter customer salary: ");
		int salary = sc.nextInt();
		System.out.println("Enter customer email: ");
		String contact = sc.next();
		AddUser au = new AddUser();
		au.addCustomer(name, gender, salary, contact);
		sc.close();
	}
	
	public void openAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What type of account would you like to open");
		System.out.println("Press 1 for Savings");
		System.out.println("Press 2 for Salary");
		System.out.println("Press 3 for Current");
		int acct_type = sc.nextInt();
		System.out.println("How much would you like to deposit?");
		int deposit = sc.nextInt();
		String acct_name = "";
		if(acct_type == 1) {
			acct_name = "savings_account";
		} else if (acct_type == 2) {
			acct_name = "salary_account";
		} else if (acct_type == 3) {
			acct_name = "current_account";
		}
		System.out.println("What is the contact of the customer for the account");
		String name = sc.next();
		int cust_id = cs.retrieveCust(name);
		AddAccount aa = new AddAccount();
		aa.openAnAccount(acct_name, cust_id, deposit);
		sc.close();
	};
	
	public void depositToAccount() {
		Scanner sc = new Scanner(System.in);
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
		sc.close();
	}
	
	public void withdrawFromAccount() {
		Scanner sc = new Scanner(System.in);
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
		sc.close();
	}
	
	public void transaction() {
		Scanner sc = new Scanner(System.in);
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
		sc.close();
	}
	
	public static void main(String[] args) {
		BankApplication ba = new BankApplication();
		ba.bankRunner();
		}
		
		public void retrieveStatement() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Which account statement would you like to look at");
			sc.close();
		}
		
		public void bankRunner() {
			BankApplication ba = new BankApplication();
			Scanner sc = new Scanner(System.in);
			System.out.println("What would you like to do:");
			System.out.println("Press 1 to add a customer");
			System.out.println("Press 2 to open a new account with a customer");
			System.out.println("Press 3 to make a transaction");
			System.out.println("Press 4 to get an account statement");
			int opening = sc.nextInt();
			int transaction;
			if(opening == 1) {
				ba.addUser();
			} else if (opening == 2) {
				ba.openAccount();
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
			}
			sc.close();
		}
		
		
	}

