import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Prompt5 {
	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 5: BufferedReader and BufferedWriter");
		BufferOperation.readWrite("name.txt","target.txt");
			
		
	}
}

class BufferOperation{
	private static BufferedReader openReader(String source) {
		BufferedReader read = null;
		try {
			read = new BufferedReader(new FileReader(source));
		} catch (FileNotFoundException e) {
			System.out.printf("File '%s' not found\n", source);
			newSource(source);
			try {
				read = new BufferedReader(new FileReader(source));
				System.out.printf("File '%s' created successfully\n", source);
			} catch (FileNotFoundException e1) {
				System.out.printf("File '%s' not found and cannot be created\n", source);
			}
		}
		return read;
	}
	
	private static BufferedWriter openWriter(String target){
		try {
			return new BufferedWriter( new FileWriter(new File(target)));
		} catch (IOException e) {
			System.out.printf("Unable to open file '%s'\n", target);
		}
		return null;
	}
	
	public static void readWrite(String source, String target) {
		ArrayList<String> lines = readBuffer(source);
		writeBuffer(target, lines);
		
	}
	
	public static ArrayList<String> readBuffer(String source) {
		System.out.println("Reading");
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader read = null;
			read = openReader(source);
			String line;
			while((line = read.readLine()) != null) {
				lines.add(line);
				System.out.printf("    %s\n",line);
			}
			read.close();
		} catch (IOException e) {
			System.out.printf("Failed to read from '%s'\n", source);
		}
		return lines;
	}
	
	public static void writeBuffer(String target, ArrayList<String> lines) {
		System.out.println("Writing");
		BufferedWriter write = null;
		try {
			write = openWriter(target);
			for(String line : lines) {
				System.out.printf("    %s\n",line);
				write.write(line);
				write.flush();
			}
			write.close();
		} catch (IOException e) {
			System.out.printf("Failed to write to '%s'\n", target);
		}
		
	}
	
	public static void newSource(String source) {
		System.out.printf("Creating new file...\n");
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("Rhea\n");
		lines.add("Ophelia\n");
		lines.add("Galatea\n");
		lines.add("Sistina\n");
		
		BufferedWriter write = null;
		try {
			write = openWriter(source);
			for(String line : lines) {
				System.out.printf("    %s",line);
				write.write(line);
				write.flush();
			}
			write.close();
		} catch (IOException e1) {
			System.out.printf("Failed to write to '%s'", source);
		}
	}
	
	
}