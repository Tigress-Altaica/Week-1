package csis2450.assignment1;

/**
 * Enum representing the standing of a customer payment account
 * 
 * @author Anneliese Braunegg
 * 
 * Date Created: Saturday, January 23, 2021
 * Date Last Updated: Sunday, January 24, 2021
 *
 */
enum AccountStanding {
	GOOD("Good"),
	FAIR("Fair"),
	POOR("Poor"),
	CLOSED("Closed");
	
	private final String stringValue;
	
	private AccountStanding(String stringValue) {
		this.stringValue = stringValue;
	}
	
	final String getStringValue() {
		return this.stringValue;
	}
	
}
