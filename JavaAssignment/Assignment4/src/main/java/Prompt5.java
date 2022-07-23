import java.util.Random;

public class Prompt5 {
	public static void execute() {
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 6: String Array and For-Each Loop\n");
		Random rand = new Random();
		String[] strArr = new String[rand.nextInt(9)+1];
		for(int i = 0; i < strArr.length; i++) {
			strArr[i] = genString(i);
		}
		System.out.printf("String Array of Size %d:\n", strArr.length);
		for(String i : strArr) {
			System.out.printf("    %s\n", i);
		}
	}
	
	public static String genString(int i) {
		return "String #" + (i+1);
		
	}
}
