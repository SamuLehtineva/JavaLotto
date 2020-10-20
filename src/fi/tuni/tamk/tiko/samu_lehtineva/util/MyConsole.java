package fi.tuni.tamk.tiko.samu_lehtineva.util;

import java.io.Console;
/**
*This class contains some Console methods that use user inputs.
*
*@author Samu Lehtineva
*/

public class MyConsole {
	/**
	*This method asks the user for an integer.
	*If the input is not an integer it will print an error message and ask again.
	*If the input is not within the range of the minimum and maximum values it will print an error message and ask again.
	*
	*@param min The minimum value that the integer is allowed to be.
	*@param max The maximum value that the integer is allowed to be.
	*@param errorMessageNonNumeric The text that is printed if the input is not an integer.
	*@param errorMessageNonMinAndMax The text that is printed if the input is not within the range of the min and max parameters.
	*
	*@return the user inputted integer.
	*/
	public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
		Console c = System.console();
		boolean error = true;
		int input = 0;
		while (error) {
			System.out.println("Give a unique number between (" + min + " - " + max + ")");
			try {
				input = Integer.parseInt(c.readLine());
				if (input >= min && input <= max) {
					error = false;
				} else {
					System.out.println(errorMessageNonMinAndMax);
				}
			} catch (NumberFormatException e) {
				System.out.println(errorMessageNonNumeric);
			}
		}
		return input;
	}
	/**
	*This method Asks the user to confirm or deny.
	*Then it returns boolean value that is either true or false depending on the users answer.
	*@param message The message that is to  be confirmed or denied.
	*@param confirm If the users input matches this String, it is considered a confirmation.
	*@param deny If the users input matches this String, the message is denied.
	*@return A boolean, that is true if the message is confirmed, or false if the message is denied.
	*/
	public static boolean readConfirm(String message, String confirm, String deny) {
		boolean check = false;
		Console c = System.console();
		String input = "";
		while (!input.equalsIgnoreCase(confirm) && !input.equalsIgnoreCase(deny)) {
			System.out.println(message + " Type " + confirm + "/" + deny);
			input = c.readLine();
			if (input.equalsIgnoreCase(confirm)) {
				check = true;
			} else if (input.equalsIgnoreCase(deny)) {
				check = false;
			} else {
				System.out.println("Wrong input!");
			}
		}
		
		return check;
	}
}