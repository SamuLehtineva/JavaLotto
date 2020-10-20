package fi.tuni.tamk.tiko.samu_lehtineva.util;
/**
*This Math class contains number related functions
*
*@author Samu Lehtineva
*/
public class Math {
    /**
    *This method receives two integers (min and max) and returns a random integer from that range.
    *@param min The minimum value of the return.
    *@param max The maximum value of the return.
    *@return The random number generated in the method.
    */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
    /**
	*Returns the length of an integer
	*
	*@param number The integer you want the length of.
	*@return The amount of digits in the integer.
	*/
	public static int getIntLength(int number) {
        int length = 0;
        long temp = 1;
        while (temp <= number) {
            length++;
            temp *= 10;
		}
        return length;
	}
}