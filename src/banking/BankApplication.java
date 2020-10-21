package banking;

import java.util.Scanner;
import accounts.SavingsAccount;
import database.AddUser;
import database.AddAccount;

public class BankApplication {
	
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
		// Need to add auto incrementing integer
	}
	
	public void openAccount() {
		
	};
	
	public void depositToAccount() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Which account would you like to deposit to?");
		System.out.println("Press 1 for Savings");
		System.out.println("Press 2 for Salary");
		System.out.println("Press 3 for Current");
		int choice = sc.nextInt();
		// need to have what ever user it is
		switch(choice) {
		case 1:
			SavingsAccount save = new SavingsAccount();
		}
		
	}
	
	public static void main(String[] args) {
		BankApplication ba = new BankApplication();
		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do:");
		System.out.println("Press 1 to add a customer");
		System.out.println("Press 2 to open a new account with a customer");
		System.out.println("Press 3 to make a transaction");
		int opening = sc.nextInt();
		int transaction;
		int acct;
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
				System.out.println("Which account would you like to deposit to?");
				System.out.println("Press 1 for savings account?");
				System.out.println("Press 2 for salary account?");
				System.out.println("Press 3 for current account?");
			} else if(transaction == 2) {
				System.out.println("Which account would you like to withdraw from?");
				System.out.println("Press 1 for savings account?");
				System.out.println("Press 2 for salary account?");
				System.out.println("Press 3 for current account?");
			} else if (transaction == 3) {
				System.out.println("Which accounts would you like to transfer from and to?");
				System.out.println("Press 1 for savings to salary");
				System.out.println("Press 2 for savings to current");
				System.out.println("Press 3 for salary to savings");
				System.out.println("Press 4 for salary to current");
				System.out.println("Press 5 for current to savings");
				System.out.println("Press 6 for current to salary");
				}
			}
		
		
		sc.close();
		}
		
		
		
		
	}

