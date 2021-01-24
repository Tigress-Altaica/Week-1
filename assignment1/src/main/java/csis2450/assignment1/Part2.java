package csis2450.assignment1;

import static csis2450.assignment1.Assignment1Arrays.CUSTOMERS;
import static csis2450.assignment1.Assignment1Arrays.PAYMENTS;

/**
 * CSIS 2450: Assignment 2: Part 2
 * 
 * @author Anneliese Braunegg
 *
 */
public final class Part2 {
	
	/**
	 * Return the account standing for an account with the given number
	 * of zero (0) payments.
	 * 
	 * @param numOfZeroPayments: The number of zero (0) payments
	 * 
	 * @return: The corresponding account standing
	 */
	private static final String accountStanding(int numOfZeroPayments) {
		assert numOfZeroPayments >= 0;
		
		String accountStanding;
		
		if (numOfZeroPayments == 0) {
			accountStanding = AccountStanding.GOOD.getStringValue();
		}
		else if (numOfZeroPayments == 1) {
			accountStanding = AccountStanding.FAIR.getStringValue();
		}
		else if (numOfZeroPayments == 2) {
			accountStanding = AccountStanding.POOR.getStringValue();
		}
		else {
			accountStanding = AccountStanding.CLOSED.getStringValue();
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
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		System.out.println("Customer Payment History");
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		System.out.println("Name Account 01 02 03 04 05 06 07 08 09 10 11 12 Standing");
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		
		/* Print out a line for each customer in CUSTOMERS */
		for (int custNum = 0; custNum < CUSTOMERS.length; custNum++) {
			// Customer name
			System.out.print(CUSTOMERS[custNum] + " ");
			
			// Account number
			System.out.print((int) PAYMENTS[custNum][0]);
			
			// Payments
			int numOfZeroPayments = 0;
			for (int payNum = 1; payNum < PAYMENTS.length; payNum++) {
				double payAmt = PAYMENTS[custNum][payNum];
				System.out.print(payAmt + " ");
				
				if (payAmt == 0) {
					numOfZeroPayments += 1;
				}
			}
			
			// Account standing
			String accountStanding = accountStanding(numOfZeroPayments);
			System.out.print(accountStanding + System.lineSeparator());
		}
	}

}
