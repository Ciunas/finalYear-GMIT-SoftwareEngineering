package assignmentJUNIT.multiclass;

/**
 *
 * A SmartPhone is an extension of a MobilePhone
 * 
 * gives the user new features like web browsing with the browseWeb(String)
 * method and allows the user to find their GPS position with findPosition().
 *
 */

public class SmartPhone extends MobilePhone {

	public boolean browseWebCalled = false;
	public boolean callCalled = false;
	public boolean playGameCalled = false;
	public boolean findPositionCalled = false;

	/**
	 *
	 * Constructor calls the super class constructor with the String brand
	 * representing the brand of the Phone
	 *
	 * @param brand
	 *            the String to be put into the superclass constructor
	 *
	 */
	public SmartPhone(String brand) {
		super(brand);
	}

	/**
	 *
	 * call() function checks if the first two chars of the number parameter are
	 * '0' and '0' if so, prints a message that the call has be placed through
	 * the internet
	 * 
	 * else, calls the superclass call() function with String number
	 *
	 * @param number
	 *            the number to be called.
	 *
	 */
	public void call(String number) {
		callCalled = true;
		if (number.charAt(0) == '0' && number.charAt(1) == '0') {
			// System.out.println("Calling " + number + " through the internet
			// to save money");
		} else {
			super.call(number);
		}
	}

	/**
	 *
	 * Overrides the playGame() method, increasing its visibility calls the
	 * printGame() method from the SmartPhone super class, MobilePhone
	 *
	 * @param game
	 *            the String to be put in the super printGame(String) method
	 *
	 */
	public void playGame(String game) {
		playGameCalled = true;
		super.printGame(game);
	}

	/**
	 *
	 * browseWeb() function allows the user to browse the web
	 *
	 * @param website
	 *            the website to be browsed
	 *
	 */
	public void browseWeb(String website) {
		browseWebCalled = true;
		// System.out.println("Going to website " + website);
	}

	/**
	 *
	 * findPosition() returns the current GPS position of the SmartPhone
	 *
	 * @return the current GPS position
	 *
	 */
	public int findPosition() {
		findPositionCalled = true;
		return 12;
	}
}