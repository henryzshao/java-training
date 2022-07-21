package assignment2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Problem3 {
	public static void evenOdd(Scanner in) {
		int i = readInput(in);
		
		if(i%2==0) {
			System.out.println("    "+i+" is Even");
		}
		else {
			System.out.println("    "+i+" is Odd");
		}
	}
	
	public static int readInput(Scanner in) {
		System.out.print("    Input a number: ");
		int i;
		try{
			i = in.nextInt();
		}
		catch (InputMismatchException e) {
			Random rand = new Random();
			i = rand.nextInt(1000);
			System.out.println("    The entered value is not a number. Using " + i);
		}
		in.nextLine();
		return i;

	}
}
