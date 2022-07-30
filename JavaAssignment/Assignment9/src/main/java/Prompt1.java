import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//Program for reading Binary File
public class Prompt1{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 1: Read File with ByteStream");
			String source = "source.txt";
			ByteStreamOperation.readByte(source);
	}

}

class ByteStreamOperation {
	public static void readWriteByte(String sourceFile, String targetFile){
		FileInputStream source = null;
		FileOutputStream target = null;

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
	
	public static ArrayList<Integer> readByte(String sourceFile) {
		FileInputStream source = null;
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
	
	public static void writeByte(String targetFile, ArrayList<Integer> arrList) {
		FileOutputStream target = null;

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
		readByte(targetFile);
	}
	
	private static FileInputStream openSourceFile(FileInputStream source, String fileName){
		try {
			source = new FileInputStream(fileName);
			System.out.printf("Opened '%s'\n", fileName);
			return source;
		} catch (FileNotFoundException e) {
			try {
				createSourceFile(fileName);
				source = new FileInputStream(fileName);
			} catch (FileNotFoundException e1) {
				System.out.printf("Open file '%s' failed...\n", fileName);
			}
			return source;
		}
	}
	
	private static FileOutputStream openTargetFile(FileOutputStream target, String fileName) {
		try {
			System.out.printf("Opened '%s'\n", fileName);
			return new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			System.out.printf("Failed to open or create '%s'\n", fileName);
			return target;
		}
	}
	
	private static void createSourceFile(String fileName) {

		try {
			System.out.printf("'%s' failed, creating file...\n", fileName);
			FileOutputStream newFile = new FileOutputStream(fileName);
			int i = 0;
			Random rand = new Random();
			while(i < 100) {
				newFile.write((byte)i);
				i = i + rand.nextInt(10);
			}
			newFile.close();
		} catch(FileNotFoundException e) {
			System.out.printf("Failed to create '%s'\n", fileName);
		} catch (IOException e) {
			System.out.printf("Failed to write to new file '%s'\n", fileName);
		}
	}
	
	
}
