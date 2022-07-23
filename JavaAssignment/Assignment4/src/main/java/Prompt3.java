
public class Prompt3 {
	public static void execute() {
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 3: StringBuilder Methods\n");
		String str1 = new String("This is a String");
		StringBuilder sb = new StringBuilder(str1);
		System.out.printf("sb:\n    %s\n", sb);
		
		
		System.out.printf("sb.length():\n    %d\n",sb.length());
		System.out.printf("sb.capacity():\n    %d\n",sb.capacity());
		System.out.printf("sb.append(\"Buffer\"):\n    %s\n",sb.append("Builder"));
		System.out.printf("sb.insert(8, \"not \"):\n    %s\n",sb.insert(8, "not "));
		System.out.printf("sb.delete(8, 12):\n    %s\n",sb.delete(8, 12));
		System.out.printf("sb.reverse():\n    %s\n",sb.reverse());
		
	}
}
