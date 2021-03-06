package csis2450.assignment1;

import java.util.Scanner;

import static csis2450.assignment1.Assignment1Arrays.ARRAY;

/**
 *
 * CSIS 2450: Assignment 1: Part 1
 * 
 * @author Anneliese Braunegg
 * 
 * Date Created: Saturday, January 23, 2021
 * Date Last Updated: Sunday, January 24, 2021
 *
 */
public final class Part1 {
	
	/**
	 * Return the English ordinal suffix for the given integer.
	 * 
	 * @param intNum: The integer
	 * 
	 * @return: The integer's ordinal suffix
	 */
	private static final String ordinalSuffix(int intNum) {
		String ordinalSuffix;
		
		if (10 < intNum % 100 && intNum % 100 < 20) {
			ordinalSuffix = "th";
		}
		else if (intNum % 10 == 1) {
			ordinalSuffix = "st";
		}
		else if (intNum % 10 == 2) {
			ordinalSuffix = "nd";
		}
		else if (intNum % 10 == 3) {
			ordinalSuffix = "rd";
		}
		else {
			ordinalSuffix = "th";
		}
		
		return ordinalSuffix;
	}
	
	/**
	 * Prompt the user for an integer between 1 and 50. Once the user
	 * has entered such an integer, locate the integer in ARRAY and print
	 * out the user's integer and its position in ARRAY in a user-friendly
	 * sentence.
	 * 
	 * @param args: This parameter is not used.
	 */
	public static void main(String[] args) {
		/* Prompt the user for an integer between 1 and 50 until they
		 * enter such an integer.
		 */
		System.out.println("Please enter an integer between 1 and 50"
			+ " (inclusive). Your integer will be located\n"
			+ "in the stored integer array, and you will receive a printed"
			+ " message telling you the\n"
			+ "integer you entered and its position in the array.");
		System.out.println();
		System.out.print("Integer to locate: ");
		
		Scanner scanner = new Scanner(System.in);
		String pleaseEnterMessage = "Please enter an integer"
				+ " between 1 and 50: ";
		int userInt = -1;
		while (userInt < 1 || 50 < userInt) {
			if (scanner.hasNext()) {
				if (!scanner.hasNextInt()) {
					scanner.next();
					System.out.print(pleaseEnterMessage);
					continue;
				}
				
				userInt = scanner.nextInt();
				
				if (userInt < 1 || 50 < userInt) {
					System.out.print(pleaseEnterMessage);
				}
			}
		}
		
		/* Search ARRAY for the number that the user has
		 * entered.
		 */
		for (int i = 0; i < ARRAY.length; i++) {			
			/* Once the number has been located, print the number and
			 * its position in ARRAY to the console in a
			 * user-friendly sentence.
			 */
			if (ARRAY[i] == userInt) {
				String ordinalSuffix = ordinalSuffix(i + 1);
				System.out.println();
				System.out.println("The integer you entered was: "
					+ userInt + ", and it was the " + (i + 1)
					+ ordinalSuffix + " integer in the stored array of\n"
					+ "integers.");
				break;
			}
		}
		
		/* Close the Scanner used to receive user input. */
		scanner.close();
	}

}
