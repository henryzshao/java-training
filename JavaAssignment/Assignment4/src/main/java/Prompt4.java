import java.util.Random;

public class Prompt4 {
	public static void execute() {
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 5: Integer Array (Odd/Even Sums)\n");
		Random rand = new Random();
		int[] intArr = new int[10];
		for(int i = 0; i < 10; i++) {
			intArr[i] = genRandomInt(rand);
		}
		System.out.print("Integer Array of Size 10: \n   ");
		for(int i : intArr) {
			System.out.printf("%d ", i);
		}
		System.out.println("\n");	
		
		System.out.printf("Sum of Even Values:\n    %d\n", sumEvenArray(intArr));
		System.out.printf("Sum of Odd Values:\n    %d\n", sumOddArray(intArr));
	}
	
	public static int genRandomInt(Random rand) {
		return rand.nextInt(10);
		
	}
	
	public static int sumEvenArray(int[] intArr) {
		int sum = 0;
		for(int i : intArr) {
			if(i%2==0) {
				sum = sum + i;
			}
		}
		return sum;
	}
	
	public static int sumOddArray(int[] intArr) {
		int sum = 0;
		for(int i : intArr) {
			if(i%2==1) {
				sum = sum + i;
			}
		}
		return sum;
	}
}
