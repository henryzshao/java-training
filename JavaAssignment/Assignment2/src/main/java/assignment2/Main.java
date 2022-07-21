package assignment2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		problem1(in);
		problem2(in);
		problem3(in);
		problem4(in);
		problem5(in);
		problem6(in);
		problem7(in);
		problem8(in);
		problem9(in);
		problem10(in);
		problem11(in);
	}
	
	public static void problem1(Scanner in) {
		System.out.print("Problem 1: Operations");
		in.nextLine();
		System.out.println("    i = 1 and j = 5");
		int i = 1;
		int j = 5;
		Problem1.arithmeticOperation(i, j);
		Problem1.relationalOperation(i, j);
		Problem1.unaryOperation(i);
	}
	
	public static void problem2(Scanner in) {
		System.out.println("Problem 2: Check Argument for Even or Odd");
		Problem2.evenOdd(in);
	}
	
	public static void problem3(Scanner in) {
		System.out.println("Problem 3: Print Number and Even/Odd");
		Problem3.evenOdd(in);
	}
	
	public static void problem4(Scanner in) {
		System.out.println("Problem 4: Print the Word of the Integer");
		System.out.println("    "+Problem4.intToString(in));
	}
	
	public static void problem5(Scanner in) {
		System.out.print("Problem 5: Print Even from 1-100 with For Loop");
		in.nextLine();
		Problem5.oneToHundred();
	}
	
	public static void problem6(Scanner in) {
		System.out.print("Problem 6: Print 1-5 5 Times with Nested For Loop");
		in.nextLine();
		Problem6.oneToFive();
	}
	
	public static void problem7(Scanner in) {
		System.out.print("Problem 7: Print 1-25 with While Loop");
		in.nextLine();
		Problem7.oneTo25();
	}
	
	public static void problem8(Scanner in) {
		System.out.print("Problem 8: Print Odd from 50-100 with Do-While Loop");
		in.nextLine();
		Problem8.OddTo100();
	}
	
	public static void problem9(Scanner in) {
		System.out.print("Problem 9: Print Prime from 1-100");
		in.nextLine();
		Problem9.primeTo100();
	}
	
	public static void problem10(Scanner in) {
		System.out.print("Problem 10: Print Odd from 1-100 with Continue");
		in.nextLine();
		Problem10.printOddContinue();
	}
	
	public static void problem11(Scanner in) {
		System.out.print("Problem 11: Print Even from 50-75 with Break");
		in.nextLine();
		Problem11.printEvenBreak();
	}

}
