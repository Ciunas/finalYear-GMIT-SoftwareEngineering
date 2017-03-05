package assignmentJUNIT.multiclass;

/**
 * OldPhone implements Phone They are old so they can only make calls
 */

public class OldPhone implements Phone {

	private String brand = null;

	/**
	 *
	 * constructor stores the parameter brand in the field brand
	 *
	 * @param brand
	 *            is the brand of the phone
	 *
	 */
	public OldPhone(String brand) {
		this.brand = brand;
	}

	/**
	 *
	 * returns the brand of the phone
	 *
	 * @return the brand of the phone
	 *
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Prints a statement telling the user that the phone is calling their
	 * number
	 * 
	 * @Param number the number to be dialed
	 */
	public void call(String number) {
		System.out.println("Calling " + number);
	}
}