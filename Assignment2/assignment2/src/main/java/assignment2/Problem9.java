package assignment2;

public class Problem9 {
	public static void primeTo100() {
		for(int i = 2; i <= 100; i++) {
			int notprime = 0;
			for(int j = 2; j <= i; j++) {
				if(i%j==0) {
					notprime++;
				}
			}
			
			if(notprime == 1) {
				System.out.printf("    %d\n", i);
			}
			
		}
	}
}
