import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Prompt2 {
	
	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 2\n");
		
		ArrayList<Obj> list = new ArrayList<Obj>();
		list.add(new Obj(8, "ABA"));
		list.add(new Obj(3, "ACA"));
		list.add(new Obj(4, "ADA"));
		list.add(new Obj(1, "AAA"));
		
		Prompt2.iterate(list);
		System.out.println("Sort (Comparable) by int!");
		Collections.sort(list);
		Prompt2.iterate(list);
		System.out.println("Sort (Comparator) by string (backwards)!");
		ComparatorStr comp = new ComparatorStr();
		Collections.sort(list, comp);
		Prompt2.iterate(list);
	}
	
	public static void iterate(ArrayList<Obj> list) {
		System.out.print("Iterating: ");
		Iterator<Obj> it = list.iterator();
	    while(it.hasNext()) {
	    	Obj temp = it.next();
	    	int i = temp.i;
	    	String str = temp.str;
	    	System.out.printf("(%d,\"%s\") ", i, str);
	    }
	    System.out.println();
	}
	
}

class Obj implements Comparable<Obj>{

	public int i;
	public String str;
	
	public Obj(int a, String b) {
		i = a;
		str = b;
	}
	
	public int compareTo(Obj o) {
		return this.i - o.i;
	}
	
}

class ComparatorStr implements Comparator<Obj>{
	public int compare(Obj o1, Obj o2) {
		if((o1.str.charAt(1)) < (o2.str.charAt(1))) {
			return 1;
		} else if ((o1.str.charAt(1)) > (o2.str.charAt(1))){
			return -1;
		}
		else {
			return 0;
		}
	}
	
}