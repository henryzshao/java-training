package assignment2;

public class Problem8 {
	public static void OddTo100() {
		int i = 50;
		do {
			if(i%2==1) {
				System.out.printf("    %d\n", i);
			}
			i++;
		} while (i <= 100);
	}
}
