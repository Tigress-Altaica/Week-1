package csis2450.assignment1;

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
