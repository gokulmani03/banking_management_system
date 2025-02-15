package banking;

import java.util.Scanner;

public class BankAccount {
	
	    int balance;
	    String customerName;
	    String customerId;
	    int previousTransaction;

	    BankAccount(String cname, String cid) {
	        customerName = cname;
	        customerId = cid;
	    }

	    void deposit(int amount) {
	        if (amount > 0) {
	            balance += amount;
	            previousTransaction = amount;
	        } 
	        else {
	            System.out.println("Invalid deposit amount. Please enter a positive amount.");
	        }
	    }

	    void withdraw(int amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            previousTransaction = -amount;
	        } 
	        else if (amount > balance) {
	            System.out.println("Insufficient funds!");
	        }
	        else {
	            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
	        }
	    }

	    void getPreviousTransaction() {
	        if (previousTransaction > 0) {
	            System.out.println("Deposited: " + previousTransaction);
	        } 
	        else if (previousTransaction < 0) {
	            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
	        }
	        else {
	            System.out.println("No transaction occurred.");
	        }
	    }

	    void showMenu() {
	        char option = '\0';
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("WELCOME TO BANKING MANAGEMENT SYSTEM ");
	        System.out.println("Your Name: " + customerName);
	        System.out.println("Your ID: " + customerId);
	        System.out.println("\n");
	        System.out.println("Select The Options...!");
	        System.out.println("1. Create an Account");
	        System.out.println("2. Check Balance");
	        System.out.println("3. Deposit");
	        System.out.println("4. Withdraw");
	        System.out.println("5. Previous Transaction");
	        System.out.println("6. Exit");

	        do { 
	        	System.out.println("\n");
	            System.out.println("*****************************************************");
	            System.out.println("Enter your option: ");
	            System.out.println("*****************************************************");
	            System.out.println("\n");
	            option = scanner.next().charAt(0);
	           

	            switch (option) {
	                case '1':
	                    System.out.println("Enter your Name: ");
	                    scanner.nextLine(); 
	                    String name = scanner.nextLine();
	                    System.out.println("Enter your Customer ID: ");
	                    String id = scanner.next();
	                    BankAccount newAccount = new BankAccount(name, id);
	                    System.out.println("Account successfully created for " + newAccount.customerName);
	                    break;

	                case '2':
	                   
	                    System.out.println("Balance = " + balance);
	                    break;

	                case '3':
	                    System.out.println("Enter an Amount to Deposit:");
	                    int depositAmount = scanner.nextInt();
	                    deposit(depositAmount);
	                    System.out.println("Amount Deposited successfully");
	                    break;

	                case '4':
	                    System.out.println("Enter an Amount to Withdrawal:");
	                    int withdrawAmount = scanner.nextInt();
	                    if (withdrawAmount > balance) {
	                        System.out.println("Error: Insufficient Amount..!");
	                    } else {
	                    	System.out.println("Amount Withdrawal successfully");
	                        withdraw(withdrawAmount);
	                    }
	                    break;

	                case '5':
	                    getPreviousTransaction();
	                    break;

	                case '6':
	                    System.out.println("Thank you for using our services...");
	                    break;

	                default:
	                    System.out.println("Invalid option! Please enter a correct option.");
	                    break;
	            }
	        } 
	        while (option != 6);

	       scanner.close();
	    }
}


