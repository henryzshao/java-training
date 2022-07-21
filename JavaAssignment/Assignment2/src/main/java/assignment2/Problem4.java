package assignment2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Problem4 {
	public static String intToString(Scanner in) {
		
		int i = readInput(in);
		switch (i) {
			case 1: return "One";
			case 2: return "Two";
			case 3: return "Three";
			case 4: return "Four";
			case 5: return "Five";
			case 6: return "Six";
			case 7: return "Seven";
			case 8: return "Eight";
			case 9: return "Nine";
			case 10: return "Ten";
			default: return "Error";
			
		}
		
	}
	
	public static int generateNumber() {
		Random rand = new Random();
		return rand.nextInt(9)+1;
	}
	
	public static int readInput(Scanner in) {		
		System.out.print("    Input a integer between 1 and 10 (inclusive): ");
		int i;
		try{
			i = in.nextInt();
			if(i > 10 || i < 1) {
				i = generateNumber();
				System.out.println("    The entered value is not within bounds. Using " + i);
			}
		}
		catch (InputMismatchException e) {
			i = generateNumber();
			System.out.println("    The entered value is not a number. Using " + i);
		}
		in.nextLine();
		return i;
	}
}
