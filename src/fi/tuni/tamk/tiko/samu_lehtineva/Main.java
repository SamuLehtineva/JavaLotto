package fi.tuni.tamk.tiko.samu_lehtineva;

import fi.tuni.tamk.tiko.samu_lehtineva.util.Math;
import fi.tuni.tamk.tiko.samu_lehtineva.util.Arrays;
import fi.tuni.tamk.tiko.samu_lehtineva.util.MyConsole;
/**
*This Main class controls the lotto system
*It simulates how long it would take to win the lottery.
*
*@author Samu Lehtineva
*/
public class Main {
    /**
    *This method receives a series of numbers from the user. Either through command line argument or through one by one input.
    *The amount of required numbers is defined by the "gameLength" integer.
    *The maximum value for the integers is defined by the "lottoMax" integer.
    *
    *After receiving the numbers, it asks the user if they want to see the winning numbers, and stores the answer in a boolean.
    *It then generates an integer array filled with random numbers and checks how many values they share in common.
    *The process repeats until a win is reached within 120 years.
    */
    public static void main(String [] args) {
        int gameLength = 7;
        int lottoMax = 40;
        int[] numbers = new int[gameLength];
        int current = 0;
        int years = 0;
        if (args.length == gameLength) {
            try {
                int g = Integer.parseInt(args[0]);
                numbers = Arrays.checkToIntArray(args, 1, lottoMax);
			} catch (NumberFormatException e) {
                System.out.println("Arguments must be integers");
                System.exit(1);
			}
		} else {
            for (int i = 0; i < numbers.length; i++) {
                current = MyConsole.readInt(1, lottoMax, "Not a number :(", "Wrong value");
                if (Arrays.contains(current, numbers)) {
                    System.out.println("Not a unique number");
                    i--;
			    } else {
                    numbers[i] = current;
			    }
		    }
		}
        boolean showWins = MyConsole.readConfirm("Do you want to see smaller wins?", "yes", "no");
        do {
            years = runLotto(numbers, showWins, gameLength, lottoMax);
            if (years > 120) {
                System.out.println("You won!!! But it took " + years + " years, that's more than a lifetime, lets try again.");
                System.out.println();
			}
		} while (years > 120);
        System.out.println("You won!!! It only took " + years +" years");
    }
    /**
    *This method calculates how many years it takes to win
    *
    *@param numbers The lotto numbers given by the user.
    *@param showWins A boolean that determines wether or not to print out the winning numbers.
    *@param gameLength The amount of lotto numbers.
    *@param lottoMax the maximum value of the lotto numbers.
    *
    *@return The amount of years it took to get every number right.
    */
    private static int runLotto(int[] numbers, boolean showWins, int gameLength, int lottoMax) {
        int weeks = 0;
        int years = 0;
        int wins = 0;
        int nextWin = 1;
        while (wins < gameLength) {
            int[] winNumbers = calculateLotto(gameLength, lottoMax);
            wins = Arrays.containsSameValues(numbers, winNumbers);
            weeks++;
            if (weeks == 52) {
                years++;
                weeks = 0;
			}
            if (wins >= nextWin && showWins) {
                Arrays.printIntArray(numbers, "User lotto: [", 2, ",", "]");
                Arrays.printIntArray(winNumbers, "Random lotto: [", 2, ",", "]");
                do {
                    System.out.println("Got " + nextWin + " right! Took " + years + " years");
                    nextWin++;
				} while (nextWin < wins);
                System.out.println();
			}
		}
        return years;
	}
    /**
    *This method creates an int array with unique random integers from a specified range.
    *
    *@param gameLength Length of the array.
    *@param lottoMax Maximum value of the random integers.
    *
    *@return The array with 7 unique integers from the specified range.
    */
    private static int[] calculateLotto(int gameLength, int lottoMax) {
        int[] winNumbers = new int[gameLength];
        int current = 0;
        for (int i = 0; i < winNumbers.length; i++) {
            current = Math.getRandom(1, lottoMax);
            if (Arrays.contains(current, winNumbers)) {
                i--;
		    } else {
                winNumbers[i] = current;
			}
		}
        return winNumbers;
	}
}