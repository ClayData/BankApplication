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
		
		if(opening == 1) {
			ba.addUser();
		} else if (opening == 2) {
			ba.openAccount();
		}
		
		
	}
}
