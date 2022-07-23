import java.util.Random;

public class Prompt6 {
	public static void execute() {
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 6: Display a 2D Array in Matrix Format\n");
		Random rand = new Random();
		int[][] intArr = new int[rand.nextInt(3)+3][rand.nextInt(3)+3];
		
		for(int[] i : intArr) {
			for(int j = 0; j < i.length; j++) {
				i[j] = Prompt4.genRandomInt(rand);
			}
		}
		System.out.printf("2D Integer Array of Size %d x %d:\n", intArr.length, intArr[0].length);
		for(int[] i : intArr) {
			System.out.printf("    ");
			for(int j : i) {
				System.out.printf("%d ", j);
			}
			System.out.println();
		}
	}
	
}
