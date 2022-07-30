import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Prompt6 {
	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 6: Serializable");
		
		ArrayList<Valkyrie> list = new ArrayList<Valkyrie>();
		Valkyrie valk1 = new Valkyrie("Kaslana");
		Valkyrie valk2 = new Valkyrie("Durandal");
		Valkyrie valk3 = new Valkyrie("Rossweisse");
		list.add(valk1);
		list.add(valk2);
		list.add(valk3);
		
		String file = "valkyrie.txt";
		
		ObjectStreamOperation.serialize(file, list);
		ObjectStreamOperation.deserialize(file);
		
			
	}
}

class Valkyrie implements Serializable {
	
	private static final long serialVersionUID = 2875163739381610061L;
	String name;
	
	public Valkyrie (String name) {
		this.name = name;
	}
	
}

class ObjectStreamOperation{
	public static void serialize(String target, ArrayList<Valkyrie> list) {
		try {
			FileOutputStream file = new FileOutputStream(target);
			ObjectOutputStream out = new ObjectOutputStream(file);
			System.out.println("Serializing...");
			for (Valkyrie valk : list){
				out.writeObject(valk);
				System.out.println(valk.name);
			}
			out.close();
			file.close();
			
			System.out.println();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (NullPointerException e3) {
			e3.printStackTrace();
		}
		
	}
	
	public static ArrayList<Valkyrie> deserialize(String source) {
		ArrayList<Valkyrie> list = new ArrayList<Valkyrie>();
		try {
			
			FileInputStream file = new FileInputStream(source);
			ObjectInputStream in = new ObjectInputStream(file);
			System.out.println("Deserializing...");
			try {
				while(true) {
					list.add((Valkyrie) in.readObject());
				}
			} catch (EOFException e) {
				System.out.println("Reached end of file");
			}
			in.close();
			file.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (NullPointerException e3) {
			e3.printStackTrace();
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}
		
		System.out.println("Printing Deserialized Valkyries...");
		for (Valkyrie valk : list){
			System.out.println(valk.name);
		}	
		
		System.out.println();
		return list;
	}
}
