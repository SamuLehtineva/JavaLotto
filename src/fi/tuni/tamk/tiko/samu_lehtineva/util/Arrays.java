package fi.tuni.tamk.tiko.samu_lehtineva.util;

import fi.tuni.tamk.tiko.samu_lehtineva.util.Math;
/**
*This Arrays class contains methods for interacting with arrays
*
*@author Samu Lehtineva
*/
public class Arrays {
	/**
	*This method translates a String array into an int array.
	*
	*@param array The String array that is to be turned into an int array.
	*@return The array that was turned from String to int.
	*/
	public static int[] toIntArray(String[] array) {
		int[] inted = new int[array.length];
		for (int i = 0; i < inted.length; i++) {
			inted[i] = Integer.parseInt(array[i]);
		}
		return inted;
	}
	/**
	*This method receives an int value and an int array, and checks if the int value can be found in the array.
	*If it is found, this method returns a true, if it's not found, this returns a false.
	*
	*@param value The int that is possibly contained in the array.
	*@param array The array that possibly contains the value.
	*@return A boolean that tells if the value was found or not.
	*/
	public static boolean contains(int value, int[] array) {
		boolean check = false;
		for (int i = 0; i < array.length; i++) {
			if (value == array[i]) {
				check = true;
			}
		}
		return check;
	}
	/**
	*This method receives two int arrays and checks how many values they share with each other.
	*Everytime it finds the same value from both arrays it increases the value of int count, then it returns the count.
	*
	*@param array1 One of the arrays that is used in the check.
	*@param array2 The second array used in the check.
	*@return The amount of values shared by the arrays.
	*/
	public static int containsSameValues(int[] array1, int[] array2) {
		int count = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int k = 0; k < array2.length; k++) {
				if (array1[i] == array2[k]) {
					count++;
				}
			}
		}
		return count;
	}
	/**
	*This method receives an int array and sorts it in ascending order.
	*
	*@param array The array that is to be sorted.
	*@return The sorted array.
	*/
	public static int[] sort(int[] array) {
		int holder = array[0];
		for (int i = 0; i < array.length; i++) {
			for (int k = i; k < array.length; k++) {
				if (array[k] < array[i]) {
					holder = array[i];
					array[i] = array[k];
					array[k] = holder;
				}
			}
		}
		return array;
	}
	/**
	*This method receives an int array and prints it.
	*If the length (amount of digits) of an integer is less than the provided minimum length, that integer is prefixed with 0's to match it up.
	*
	*@param array The array that is printed.
	*@param start The String that is printed once before any data from the array.
	*@param minLength The minimum length of the printed integers.
	*@param separator The String that is printed after every object from the array except the last one.
	*@param end The String that is printed once after the data from the array.
	*/
	public static void printIntArray(int[] array, String start, int minLength, String separator, String end) {
		System.out.print(start);
		array = sort(array);
		for (int i = 0; i < array.length; i++) {
			for (int k = Math.getIntLength(array[i]); k < minLength; k++) {
				System.out.print('0');
			}
			System.out.print(array[i]);
			if (i < array.length -1) {
				System.out.print(separator);
			}
		}
		System.out.println(end);
	}
	/**
	*This method receives an String array that contains numbers and two integers and checks if the array meets the requirements.
	*If it meets the requirements, it turns the String array into an int array and returns it.
	*
	*The first requirement is that all numbers in the array are unique (only appear once)
	*The second requirement is that the numbers are within the specified range.
	*
	*@param array The array that is to be checked.
	*@param min The minimum value that the numbers in the array are allowed to be.
	*@param max The maximum value the numbers are allowed to be.
	*@return The int array.
	*/
	public static int[] checkToIntArray(String[] array, int min, int max) {
		int[] testArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int current = Integer.parseInt(array[i]);
			if (contains(current, testArray)) {
				System.out.println("All numbers must be unique");
				System.exit(1);
			} else if (current < min || current > max) {
				System.out.println("Number out of range. Acceptable range is " + min + " - " + max);
				System.exit(1);
			} else {
				testArray[i] = current;
			}
		}
		return testArray;
	}
}