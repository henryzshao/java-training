import java.util.ArrayList;

public class Prompt4 {
	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 4: Write File with CharacterStream");
			
			String source = "source.txt";
			String target = "target.txt";
			ArrayList<Integer> output = CharacterStreamOperation.readCharacter(source);
			CharacterStreamOperation.writeCharacter(target, output);
			CharacterStreamOperation.readCharacter(target);
			
	}
}
