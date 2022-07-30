import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//Program for reading Character File
public class Prompt3{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 3: Read File with CharacterStream");
			String source = "source.txt";
			CharacterStreamOperation.readCharacter(source);
	}

}

class CharacterStreamOperation {
	public static void readWriteCharacter(String sourceFile, String targetFile){
		FileReader source = null;
		FileWriter target = null;

		try {
			System.out.printf("Writing from '%s' to '%s'\n", sourceFile, targetFile);
			source = openSourceFile(source, sourceFile);
			target = openTargetFile(target, targetFile);
			
			int temp;
			while((temp = source.read()) != -1) {
				target.write((byte) temp);
				System.out.printf("%d ",temp);
			}
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(source != null) {source.close();}
				if(target != null) {target.close();}
			} catch (IOException e) {
				System.out.printf("Error closing '%s' and/or '%s'\n", sourceFile, targetFile);
			}
		}
	}
	
	public static ArrayList<Integer> readCharacter(String sourceFile) {
		FileReader source = null;
		ArrayList<Integer> intList = new ArrayList<Integer>();

		try {
			System.out.printf("Reading from '%s'\n", sourceFile);
			source = openSourceFile(source, sourceFile);
			int temp;
			while((temp = source.read()) != -1) {
				intList.add(temp);
				System.out.printf("%d ",temp);
			}
			System.out.println();
			System.out.println();
			return intList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(source != null) {source.close();}
			} catch (IOException e) {
				System.out.printf("Error closing '%s'\n", sourceFile);
			}
		}
		return null;
	}
	
	public static void writeCharacter(String targetFile, ArrayList<Integer> arrList) {
		FileWriter target = null;

		try {
			System.out.printf("Writing to '%s'\n", targetFile);
			target = openTargetFile(target, targetFile);
			
			for(int i : arrList) {
				target.write((byte) i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(target != null) {target.close();}
			} catch (IOException e) {
				System.out.printf("Error closing '%s'\n", targetFile);
			}
		}
		readCharacter(targetFile);
	}
	
	private static FileReader openSourceFile(FileReader source, String fileName){
		try {
			source = new FileReader(fileName);
			System.out.printf("Opened source '%s'\n", fileName);
			return source;
		} catch (IOException e) {
			try {
				createSourceFile(fileName);
				source = new FileReader(fileName);
			} catch (IOException e1) {
				System.out.printf("Open file '%s' failed...\n", fileName);
			}
			return source;
		}
	}
	
	private static FileWriter openTargetFile(FileWriter target, String fileName) {
		try {
			System.out.printf("Opened target '%s'\n", fileName);
			return new FileWriter(fileName);
		} catch (IOException e) {
			System.out.printf("Open file '%s' failed...\n", fileName);
		}
		return target;
	}
	
	private static void createSourceFile(String fileName) {

		try {
			System.out.printf("'%s' failed, creating file...\n", fileName);
			FileWriter newFile = new FileWriter(fileName);
			int i = 0;
			Random rand = new Random();
			while(i < 100) {
				newFile.write((byte)i);
				i = i + rand.nextInt(10);
			}
			newFile.close();
		}catch (IOException e) {
			System.out.printf("Failed to write to new file '%s'\n", fileName);
		}
	}
	
	
}
