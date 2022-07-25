
public class Prompt3 {
	public static void execute(){
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 3: Custom Exceptions\n");
		try {
			Prompt3.genArray();
		} catch (RuntimeException e){
			System.out.printf("%s\n",e.getMessage());
		}
	}
	
	public static void genArray() {
		int i = 0;
		int[] intArr = new int[10];
		try {
			for(i = 0; i <= intArr.length; i++) {
				intArr[i] = i;
			}
		} catch (ArrayIndexOutOfBoundsException e){
			if(i >= intArr.length) {
				System.out.printf("Caught Custom Unchecked Exception: ArrayHighBound\n");
				throw new ArrayHighBoundException("Error Message: The requested index "+i+" is too high. Maximum allowed is "+(intArr.length-1)+".\n", e);
			}
		}
	}
}

class ArrayHighBoundException extends RuntimeException{

	private static final long serialVersionUID = -6510330769780729305L;
	
	public ArrayHighBoundException(String errorMessage) {
		super(errorMessage);
	}
	
	public ArrayHighBoundException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}
}