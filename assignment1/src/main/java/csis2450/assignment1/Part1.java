package csis2450.assignment1;

import java.util.Scanner;

/**
 *
 * CSIS 2450: Assignment 1: Part 1
 * 
 * @author Anneliese Braunegg
 *
 */
public class Part1 {
	
	/**
	 * Return the English ordinal suffix for the given integer.
	 * 
	 * @param intNum: The integer
	 * 
	 * @return: The integer's ordinal suffix
	 */
	private static final String ordinalSuffix(int intNum) {
		String ordinalSuffix;
		
		if (intNum % 10 == 1) {
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
	 * has entered such an integer, locate the integer in ARRAY and
	 * print out the user's integer and its position in ARRAY in a
	 * user-friendly sentence.
	 * 
	 * @param args: This parameter is not used.
	 */
	public static void main(String[] args) {
		/* Prompt the user for an integer between 1 and 50 until they
		 * enter such an integer.
		 */
		System.out.println("Please type an integer between 1 and 50"
			+ " (inclusive) and then press the Enter key. Your integer"
			+ " will be located in the stored integer array, and you"
			+ " will receive a message telling you the integer you"
			+ " entered and its position in the array.");
		
		Scanner scanner = new Scanner(System.in);
		int userInt = -1;
		while (userInt < 0 || 50 < userInt) {
			if (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					userInt = scanner.nextInt();
				}
				else {
					scanner.next();
					System.out.println("Please enter an integer"
							+ " between 1 and 50");
				}
			}
		}
		
		/* Search ARRAY for the number that the user has
		 * entered.
		 */
		for (int i = 0; i < Assignment1Arrays.ARRAY.length; i++) {			
			/* Once the number has been located, print the number and
			 * its position in ARRAY to the console in a
			 * user-friendly sentence.
			 */
			if (Assignment1Arrays.ARRAY[i] == userInt) {
				String ordinalSuffix = ordinalSuffix(i + 1);
				System.out.println("The integer you entered was: "
					+ userInt + ", and it was the " + i + ordinalSuffix
					+ " integer in the stored array of integers.");
				break;
			}
		}
		
		/* Close the Scanner used to receive user input. */
		scanner.close();
	}

}