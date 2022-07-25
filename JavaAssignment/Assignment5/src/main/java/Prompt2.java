
public class Prompt2 {
	public static void execute(){
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 2: Unchecked Exceptions\n");
		
		int[] intArr = new int[10];
		try {
			for(int i = 0; i <= 10; i++) {
				intArr[i] = i;
			}
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.printf("Caught Unchecked Exception: ArrayIndexOutOfBounds\n");
		}
		
	}
}
