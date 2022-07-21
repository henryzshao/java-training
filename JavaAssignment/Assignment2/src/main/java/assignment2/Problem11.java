package assignment2;

public class Problem11 {
	public static void printEvenBreak() {
		for(int i = 50; i<=100;i++) {
			if(i==75) {
				break;
			}
			if(i%2==0) {
				System.out.printf("    %d\n", i);
			}
		}
	}
}
