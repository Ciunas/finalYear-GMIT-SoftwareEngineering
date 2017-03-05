package assignmentJUNIT.multiclass;

public class RestrictedSmartPhone extends SmartPhone {

	public String message = null;

	public RestrictedSmartPhone(String brand) {
		super(brand);
	}

	/**
	 * Attempting to override a public method with a private method results in
	 * an "attempting to assign weaker access privileges" error You cannot
	 * override a method and reduce its visibility
	 * 
	 * @return
	 *
	 */

	public void playGame(String game) {

		message = "Error: Games are not playable from Restricted Smart Phones";

	}
}