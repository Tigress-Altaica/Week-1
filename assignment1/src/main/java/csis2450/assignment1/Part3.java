package csis2450.assignment1;

import java.util.Scanner;

import static csis2450.assignment1.Assignment1Arrays.CUSTOMERS;
import static csis2450.assignment1.Assignment1Arrays.PAYMENTS;

/**
 * CSIS 2450: Assignment 1: Part 3
 * 
 * @author Anneliese Braunegg
 * 
 * Date Created: Saturday, January 23, 2021
 * Date Last Updated: Sunday, January 24, 2021
 *
 */
public class Part3 {

	/**
	 * Print out the interactive customer menu.
	 */
	private static final void printOutCustomerMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("Customer Menu");
		System.out.println("---------------------------------------------------");
		System.out.println("1. Find customer by account number.");
		System.out.println("2. Report customers with any missed payments.");
		System.out.println("3. Report customers with \"Closed\" status.");
		System.out.println("4. Exit");
		System.out.println("---------------------------------------------------");
		System.out.println("Enter 1, 2, 3, or 4 here:");
	}
	
	/**
	 * Execute menu option 1 from the interactive customer menu.
	 * 
	 * Executing menu option 1 involves doing the following:
	 * 	Print the customer record for the account number specified by the
	 * 	user, or, if no customer record for the specified account number
	 *  exists, print a message saying so.
	 * 
	 * @param scanner: The scanner being used to interact with user input
	 * 	to the menu
	 * 
	 * @return: The inputted scanner, after use in this method
	 */
	private static final Scanner executeMenuOption1(Scanner scanner) {
		System.out.print("Please enter an account number: ");
		
		int acctNum = -1;
		
		/* Receive an integral account number from the user. */
		boolean userHasEnteredIntegralAcctNum = false;
		while (!userHasEnteredIntegralAcctNum) {
			if (scanner.hasNext()) {
				if (!scanner.hasNextInt()) {
					scanner.next();
					System.out.print("Please enter an integer for"
						+ " the account number: ");
					continue;
				}
				acctNum = scanner.nextInt();
				userHasEnteredIntegralAcctNum = true;
			}
		}
		
		/* Print out the customer record for the user-specified account
		 * number. */
		int custIndex = custIndexForAcctNum(acctNum);
		if (custIndex == -1) {
			System.out.println("No customer record exists for account"
				+ " number: " + acctNum);
			System.out.println();
		}
		else {
			Part2.printOutCustomerPaymentHistory(custIndex);
			System.out.println();
		}
		
		return scanner;
	}
	
	/**
	 * Execute menu option 2 from the interactive customer menu.
	 * 
	 * Executing menu option 2 involves doing the following:
	 * 	Print the payment histories for all customers who have at least
	 *  one (1) payment of zero (0).
	 */
	private static final void executeMenuOption2() {
		System.out.println();
		
		Part2.printOutPaymentHistoryHeader();
		
		for (int i = 0; i < CUSTOMERS.length; i++) {
			if (customerHasAnyZeroPayment(i)) {
				Part2.printOutCustomerPaymentHistory(i);
			}
		}
		
		System.out.println();
	}
	
	/**
	 * Execute menu option 3 from the interactive customer menu.
	 * 
	 * Executing menu option 3 involves doing the following:
	 * 	Print the customer record for each customer whose account has
	 * 	standing AccountStanding.CLOSED.
	 */
	private static final void executeMenuOption3() {
		Part2.printOutPaymentHistoryHeader();
		
		for (int i = 0; i < CUSTOMERS.length; i++) {
			if (AccountStanding.CLOSED.equals(
					Part2.accountStanding(i))) {
				Part2.printOutCustomerPaymentHistory(i);
			}
		}
		
		System.out.println();
	}
	
	/**
	 * Execute menu option 4 from the interactive customer menu.
	 * 
	 * Executing menu option 4 involves doing the following:
	 * 	Exit the menu.
	 * 
	 * @param shouldCloseMenu: Boolean stating whether the menu should be
	 * 	closed
	 * 
	 * @return The updated value of shouldCloseMenu
	 */
	private static final boolean executeMenuOption4(boolean shouldCloseMenu) {
		System.out.println("The menu has been exited.");
		System.out.println();

		shouldCloseMenu = true;
		
		return shouldCloseMenu;
	}
	
	/**
	 * Return the index in the PAYMENTS array of the specified account
	 * number, or -1 if no account with the specified account number exists
	 * in PAYMENTS.
	 * 
	 * @param acctNum: The account number
	 * 
	 * @return: The index in PAYMENTS of the account number, or -1 if
	 * 	no account with the specified account number exists in PAYMENTS
	 */
	private static final int custIndexForAcctNum(int acctNum) {
		for (int i = 0; i < PAYMENTS.length; i++) {
			if (PAYMENTS[i][0] == acctNum) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Return a boolean stating whether the customer at the specified index
	 * in the CUSTOMERS array has at least one (1) payment of zero (0).
	 * 
	 * @param custIndex: The index of the customer
	 * 
	 * @return: Boolean stating whether the customer has at least one (1)
	 * 	payment of zero (0)
	 */
	private static final boolean customerHasAnyZeroPayment(int custIndex) {
		for (int payIndex = 1; payIndex < PAYMENTS[custIndex].length; payIndex++) {
			if (PAYMENTS[custIndex][payIndex] == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Print out an interactive menu for interacting with customer accounts.
	 * 
	 * @param args: This parameter is not used.
	 */
	public static void main(String[] args) {
		/* Print out the menu. */
		printOutCustomerMenu();
		
		/* Respond to user input. */
		Scanner scanner = new Scanner(System.in);
		String pleaseEnterMessage = "Please enter 1, 2, 3, or 4: ";
		
		boolean shouldCloseMenu = false;
		int optionInt = -1;
		
		while (!shouldCloseMenu) {
			if (scanner.hasNext()) {
				/* Handle non-integral input. */
				if (!scanner.hasNextInt()) {
					scanner.next();
					System.out.print(pleaseEnterMessage);
					continue;
				}
				
				optionInt = scanner.nextInt();
				
				switch (optionInt) {
					/* Print the customer record for the account number
					 * specified by the user, or, if no customer record
					 * for the specified account number exists, print a
					 * message saying so.
					 */
					case 1:
						scanner = executeMenuOption1(scanner);
						break;
						
					/* Print the payment histories for all customers
					 * who have at least one (1) payment of zero (0).
					 */
					case 2:
						executeMenuOption2();
						break;
					
					/* Print the customer record for each customer whose
					 * account has standing AccountStanding.CLOSED.
					 */
					case 3:
						executeMenuOption3();
						break;
					
					/* Exit the menu. */
					case 4:
						shouldCloseMenu
							= executeMenuOption4(shouldCloseMenu);
						break;
					
					/* Handle input of an out-of-range menu option. */
					default:
						System.out.println(pleaseEnterMessage);
				}
			}
		}
		
		/* Close the Scanner used to receive user input. */
		scanner.close();
	}

}
