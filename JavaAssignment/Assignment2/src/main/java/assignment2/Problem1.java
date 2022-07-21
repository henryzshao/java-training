package assignment2;

public class Problem1 {
	public static void arithmeticOperation(int i, int j) {
		System.out.println("    Arithmetic");
		System.out.printf("        Addition: %d + %d = %d\n", i, j, i+j);
		System.out.printf("        Subtraction: %d - %d = %d\n", i, j, i-j);
		System.out.printf("        Multiplication: %d x %d = %d\n", i, j, i*j);
		if(j != 0) {System.out.printf("Division: %d / %d = %d\n", i, j, i/j);}
	}
	
	public static void unaryOperation(int i) {
		System.out.println("    Unary");
		System.out.printf("        %d++ = %d\n", i++, i);
		System.out.printf("        %d-- = %d\n", i--, i);
	}
	
	public static void relationalOperation(int i, int j) {
		System.out.println("    Relational");
		if(i == j) {
			System.out.printf("        %d = %d\n",i, j);
		}
		else {
			if (i > j) {
				System.out.printf("        %d > %d\n",i, j);
			}
			else {
				System.out.printf("        %d < %d\n",i, j);
			}
		}
	}
}
