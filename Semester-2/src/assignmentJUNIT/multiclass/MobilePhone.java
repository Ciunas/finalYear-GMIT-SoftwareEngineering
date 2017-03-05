package assignmentJUNIT.multiclass;

/**
 *
 * A MobilePhone is an extension of an OldPhone
 *
 * stores the last 10 numbers that the user has dialed gives the user functions
 * for printing their last dialed numbers playing games and an alarm
 *
 */
public class MobilePhone extends OldPhone {

	public boolean ringAlarmCalled = false;
	public boolean printGameCalled = false;
	public boolean playGameCalled = false;
	public boolean printLastNumbersCalled = false;
	public boolean callCalled = false;
	/* private NumberQueue lastNumber; */
	private String[] lastNumbers;

	/**
	 *
	 * constructor calls super() constructor with the parameter brand
	 *
	 * initialises the lastNumbers String[] field with a 10 element array
	 *
	 */
	public MobilePhone(String brand) {
		super(brand);

		lastNumbers = new String[9];

		/* lastNumber = new NumberQueue(); */
	}

	/**
	 *
	 * uses the call function from the super class to call the number
	 *
	 * decision structure checks if the lastNumbers array is empty and puts the
	 * number parameter in the first positon else it creates a new String[] and
	 * stores all elements of lastNumber one position to the right reassigns
	 * lastNumbers to be the new String[]
	 *
	 * @param number
	 *            the number to be dialed.
	 *
	 */
	public void call(String number) {
		super.call(number);
		callCalled = true;
		if (lastNumbers[0] == null) {
			lastNumbers[0] = number;
		} else {
			String[] newStringArray = new String[9];
			for (int count = 0; count < lastNumbers.length - 1; count++) {
				newStringArray[count + 1] = lastNumbers[count];
			}
			newStringArray[0] = number;
			lastNumbers = newStringArray;
		}
	}

	/*
	 * NumberDialed newNumber = new NumberDialed(number, position);
	 * lastNumber.insert(newNumber);
	 */

	/**
	 *
	 * ringAlarm() function prints that the users alarm has gone off
	 *
	 * @param alarm
	 *            the String of the users alarm
	 *
	 */
	public void ringAlarm(String alarm) {
		ringAlarmCalled = true;
		// System.out.println(alarm + " has gone off.");
	}

	/**
	 *
	 * Uses reflection to access the private playGame() method
	 *
	 * @param game
	 *            the game to be put in the playGame() function
	 *
	 */
	public void printGame(String game) {
		printGameCalled = true;
		this.playGame(game);
	}

	private void playGame(String game) {
		playGameCalled = true;
		// System.out.println("You are playing " + game);
	}

	/**
	 *
	 * printLastNumbers() function cycles through the lasNumbers array prints
	 * the list of lastNumbers
	 *
	 */
	public void printLastNumbers() {
		printLastNumbersCalled = true;
		for (int count = 0; count < lastNumbers.length - 1; count++) {
			// System.out.println(lastNumbers[count]);
		}

		/* lastNumber.printNumbers(); */
	}
}