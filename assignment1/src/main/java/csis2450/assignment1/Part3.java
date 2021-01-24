package csis2450.assignment1;

import java.util.Scanner;

import static csis2450.assignment1.Assignment1Arrays.CUSTOMERS;
import static csis2450.assignment1.Assignment1Arrays.PAYMENTS;

/**
 * CSIS 2450: Assignment 1: Part 3
 * 
 * @author Anneliese Braunegg
 *
 */
public class Part3 {

	/**
	 * Print out the interactive customer menu.
	 */
	private static final void printOutCustomerMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println();
		System.out.println("Customer Menu");
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println();
		System.out.println("1. Find customer by account number.");
		System.out.println();
		System.out.println("2. Report customers with any missed payments.");
		System.out.println();
		System.out.println("3. Report customers with \"Closed\" status.");
		System.out.println();
		System.out.println("4. Exit");
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println();
		System.out.println("Enter 1, 2, 3, or 4 here:");
		System.out.println();
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
		for (int payIndex = 1; payIndex < PAYMENTS.length; payIndex++) {
			if (PAYMENTS[custIndex][payIndex] == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	// TODO: Break out menu option handling for options 1-4 into their own
	//	methods?
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
		String pleaseEnterMessage = "Please enter 1, 2, 3, or 4";
		
		boolean shouldCloseMenu = false;
		int optionInt = -1;
		
		while (!shouldCloseMenu) {
			if (scanner.hasNext()) {
				/* Handle non-integral input. */
				if (!scanner.hasNextInt()) {
					scanner.next();
					System.out.println(pleaseEnterMessage);
					continue;
				}
				
				optionInt = scanner.nextInt();
				
				switch (optionInt) {
					case 1:
						// TODO: Prompt the user for an account number,
						//	as a String.
						if (custIndex == -1) {
							System.out.println("No customer record"
								+ " exists for account number "
								+ accountNumString);
						}
						else {
							Part2.printOutCustomerPaymentHistory(custIndex);
						}
						break;
						
					/* Print the payment histories for all customers
					 * who have at least one zero (0) payment.
					 */
					case 2:
						Part2.printOutPaymentHistoryHeader();
						for (int i = 0; i < CUSTOMERS.length; i++) {
							if (customerHasAnyZeroPayment(i)) {
								Part2.printOutCustomerPaymentHistory(i);
							}
						}
						break;
						
					case 3:
						Part2.printOutPaymentHistoryHeader();
						for (int i = 0; i < CUSTOMERS.length; i++) {
							if (AccountStanding.CLOSED.equals(
									Part2.accountStanding(i))) {
								Part2.printOutCustomerPaymentHistory(i);
							}
						}
						break;
						
					case 4:
						shouldCloseMenu = true;
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
