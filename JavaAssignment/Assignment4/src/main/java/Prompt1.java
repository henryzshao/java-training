
public class Prompt1 {
	public static void execute() {
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 1: String Methods\n");
		String str1 = new String("This is a String");
		String str2 = new String(" Str2 ");
		String str3 = new String("this is a string");
		System.out.printf("str1: %s\n", str1);
		System.out.printf("str2: %s\n", str2);
		System.out.printf("str3: %s\n", str3);
		System.out.println();
		System.out.printf("str1.length(): %d\n", str1.length());
		System.out.printf("str1.concat(str2): %s\n", str1.concat(str2));
		System.out.printf("str1.toUpperCase(): %s\n", str1.toUpperCase());
		System.out.printf("str1.toLowerCase(): %s\n", str1.toLowerCase());
		System.out.printf("str1.charAt(5): %s\n", str1.charAt(5));
		System.out.printf("str1.indexOf('a'): %d\n", str1.indexOf('a'));
		System.out.printf("str1.indexOf('i',10): %d\n", str1.indexOf('i',10));
		System.out.printf("str2.trim(): %s\n", str2.trim());
		System.out.printf("str1.lastIndexOf('i', 10): %d\n", str1.lastIndexOf('i', 10));
		System.out.printf("String.valueOf(\"10\"): %s\n", String.valueOf("10"));
		System.out.printf("str1.equals(str2): %b\n", str1.equals(str2));
		System.out.printf("str1.equalsIgnoreCase(str3): %b\n", str1.equalsIgnoreCase(str3));
		
		System.out.printf("str1.toCharArray():\n");
		char[] charArr = str1.toCharArray();
		for(char a : charArr) {
			System.out.println("   "+a);
		}
		
		System.out.printf("str1.split(\" \"): \n");
		String[] strArr = str1.split(" ");
		for(String a : strArr) {
			System.out.println("   "+a);
		}
		
	}
	
}