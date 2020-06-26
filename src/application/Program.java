package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
			
		try {
			
			System.out.print("Number account: ");
			int number = sc.nextInt();
			System.out.print("Holder name: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawlimit = sc.nextDouble();
			
			Account account = new Account(number, holder, 
										  balance, withdrawlimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println("New balance: " + account.getBalance());
						
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}		
		sc.close();		
	}

}
