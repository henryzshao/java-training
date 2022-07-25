import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prompt1 {
	public static void execute(){
		System.out.println("\n--------------------------------------------------------\n"
				+ "Prompt 1: Checked Exceptions\n");
		accessFile();
	}
	
	public static void accessFile() {
		FileReader file;
		try {
			file = new FileReader("nonexistent.file");
			BufferedReader fileInput = new BufferedReader(file);
			 
	        for (int counter = 0; counter < 3; counter++)
	            System.out.println(fileInput.readLine());

	        fileInput.close();
		} catch (IOException e) {
			System.out.printf("Caught Checked Exception: IO\n");
			//e.printStackTrace();
		}

        
	}
}