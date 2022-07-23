import java.util.Random;

public class Prompt7 {
	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 7: Pass-by-Reference and -Value");
		
		Random rand = new Random();
		Value value = new Value(Prompt4.genRandomInt(rand));
		
		passByValue(value);
		passByReference(value);
	}
	
	public static void passByValue(Value value) {
		System.out.printf("Passed by Value\n");
		System.out.printf("    Value of i = %d\n", value.val);
		Value.addByValue(value.val);
		System.out.printf("    Value of i = %d\n\n", value.val);
	}
	
	public static void passByReference(Value value) {
		System.out.printf("Passed by Reference\n");
		System.out.printf("    Value of i = %d\n", value.val);
		Value.addByReference(value);
		System.out.printf("    Value of i = %d\n\n", value.val);
	}
}

class Value{
	int val = 0;
	
	public Value(int val) {
		this.val = val;
	}
	
	public static void addByValue(int i) {
		System.out.printf("    Adding 3\n");
		i = i+3;
	}
	public static void addByReference(Value value) {
		System.out.printf("    Adding 3\n");
		value.val = value.val + 3;
	}
}