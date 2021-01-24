package csis2450.assignment1;

import static csis2450.assignment1.Assignment1Arrays.CUSTOMERS;
import static csis2450.assignment1.Assignment1Arrays.PAYMENTS;

/**
 * CSIS 2450: Assignment 2: Part 2
 * 
 * @author Anneliese Braunegg
 * 
 * Date Created: Saturday, January 23, 2021
 * Date Last Updated: Sunday, January 24, 2021
 *
 */
public final class Part2 {
	
	/**
	 * Print out the header for a customer payment history report.
	 */
	static final void printOutPaymentHistoryHeader() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("Customer Payment History");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Name Account 01 02 03 04 05 06 07 08 09 10 11 12 Standing");
		System.out.println("-------------------------------------------------------------");
	}
	
	/**
	 * Print out the payment history for the customer at the specified
	 * index in the CUSTOMERS array.
	 * 
	 * @param custIndex: The index of the customer
	 */
	static final void printOutCustomerPaymentHistory(int custIndex) {
		// Customer name
		System.out.print(CUSTOMERS[custIndex] + " ");
		
		// Account number
		System.out.print((int) PAYMENTS[custIndex][0] + " ");
		
		// Payments
		int numOfZeroPayments = 0;
		for (int payIndex = 1; payIndex < PAYMENTS[0].length; payIndex++) {
			double payAmt = PAYMENTS[custIndex][payIndex];
			System.out.print(payAmt + " ");
			
			if (payAmt == 0) {
				numOfZeroPayments += 1;
			}
		}
		
		// Account standing
		AccountStanding accountStanding
			= accountStanding(numOfZeroPayments);
		System.out.print(accountStanding.getStringValue()
			+ System.lineSeparator());
	}
	
	/**
	 * Return the account standing for an account with the given number
	 * of zero (0) payments.
	 * 
	 * @param numOfZeroPayments: The number of zero (0) payments
	 * 
	 * @return: The corresponding account standing
	 */
	static final AccountStanding accountStanding(
			int numOfZeroPayments) {
		
		assert numOfZeroPayments >= 0;
		
		AccountStanding accountStanding;
		
		if (numOfZeroPayments == 0) {
			accountStanding = AccountStanding.GOOD;
		}
		else if (numOfZeroPayments == 1) {
			accountStanding = AccountStanding.FAIR;
		}
		else if (numOfZeroPayments == 2) {
			accountStanding = AccountStanding.POOR;
		}
		else {
			accountStanding = AccountStanding.CLOSED;
		}
		
		return accountStanding;
	}
	
	/**
	 * Print out a user-friendly report of the data in the arrays
	 * CUSTOMERS and PAYMENTS and the derived account Standing data.
	 * 
	 * @param args: This parameter is not used.
	 */
	public static void main(String[] args) {
		/* Print out report header */
		printOutPaymentHistoryHeader();
		
		/* Print the payment history for each customer in CUSTOMERS. */
		for (int i = 0; i < CUSTOMERS.length; i++) {
			printOutCustomerPaymentHistory(i);
		}
	}

}
