import java.util.ArrayList;

public class Prompt2 {
	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 2: Write File with ByteStream");
			
			String source = "source.txt";
			String target = "target.txt";
			ArrayList<Integer> output = ByteStreamOperation.readByte(source);
			ByteStreamOperation.writeByte(target, output);
	}
}
