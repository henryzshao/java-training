package assignment2;

public class Problem10 {
	public static void printOddContinue() {
		for(int i = 1; i<=100;i++) {
			if(i%2==0) {
				continue;
			}
			System.out.printf("    %d\n", i);
		}
	}
}
