import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Prompt1{

	public static void execute() {
		System.out.println("--------------------------------------------------------\n"
				+ "Prompt 1\n");
		Operation.arrayListOp();
		Operation.linkedListOp();
		Operation.vectorOp();
		Operation.stackOp();
		
		Operation.hashSetOp();
		Operation.linkedHashSetOp();
		Operation.treeSetOp();
		
		Operation.hashMapOp();
		Operation.linkedHashMapOp();
		Operation.treeMapOp();
	}

}

class CollectionIteration{
	
	public static void insert(Collection<Integer> col) {
		System.out.print("Inserting: ");
		Random rand = new Random();
	    for(int i = 0; i < 15; i++) {
	    	int r = rand.nextInt(9)+1;
	    	col.add(r);
	    	System.out.printf("%d ", r);
	    }
	    System.out.println();
	}
	
	public static void delOdds(Collection<Integer> col) {
		Iterator<Integer> it;
		
		System.out.print("Del Odds : ");
	    it = col.iterator();
	    while(it.hasNext()) {
	    	Integer i = it.next();
	    	if(i%2 == 1) {
	    		it.remove();
	    		System.out.printf("%d ", i);
	    	}
	    }
	    System.out.println();
	}
	
	public static void iterate(Collection<Integer> col) {
		Iterator<Integer> it;
		
		System.out.print("Iterating: ");
	    it = col.iterator();
	    while(it.hasNext()) {
	    	System.out.printf("%d ",it.next());
	    }
	    System.out.println();
	}
	
	public static void iterateAll(Collection<Integer> col) {
	    //iterate
		CollectionIteration.iterate(col);
	    
	    //remove all odd numbers
	    CollectionIteration.delOdds(col);
	    
	    //iterate
	    CollectionIteration.iterate(col);
	}

}

class MapIteration{
	
	public static void insert(AbstractMap<Integer, Integer> col) {
		System.out.print("Inserting: ");
		Random rand = new Random();
	    for(int i = 0; i < 15; i++) {
	    	int r = rand.nextInt(9)+1;
	    	col.put(i, r);
	    	System.out.printf("(%d,%d) ", i,r);
	    }
	    System.out.println();
		
	}

	public static void delOdds(AbstractMap<Integer, Integer> col) {
		System.out.print("Del Odds : ");
		Iterator<Entry<Integer, Integer>> it = col.entrySet().iterator();
	    while(it.hasNext()) {
	    	Entry<Integer, Integer> i = it.next();
	    	int key = i.getKey();
	    	int val = i.getValue();
	    	if(val%2 == 1) {
	    		it.remove();
	    		System.out.printf("(%d,%d) ", key, val);
	    	}
	    }
	    System.out.println();
	}
	
	public static void iterate(AbstractMap<Integer, Integer> col) {
		System.out.print("Iterating: ");
		Iterator<Entry<Integer, Integer>> it = col.entrySet().iterator();
	    while(it.hasNext()) {
	    	Entry<Integer, Integer> i = it.next();
	    	System.out.printf("(%d,%d) ", i.getKey(), i.getValue());
	    }
	    System.out.println();
		
	}
	
	public static void iterateAll(AbstractMap<Integer, Integer> col) {
		MapIteration.iterate(col);
		
		MapIteration.delOdds(col);
		
		MapIteration.iterate(col);
		
	}
}

class Operation{
	
	public static void arrayListOp() {
		System.out.println("ArrayList");
	    ArrayList<Integer> col = new ArrayList<Integer>();
	    
	    CollectionIteration.insert(col);
	    
	    CollectionIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	public static void linkedListOp() {
		System.out.println("LinkedList");
	    LinkedList<Integer> col = new LinkedList<Integer>();
	    
	    CollectionIteration.insert(col);
	    
	    CollectionIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	public static void vectorOp() {
		System.out.println("Vector");
	    Vector<Integer> col = new Vector<Integer>(5);
	    
	    CollectionIteration.insert(col);
	    
	    CollectionIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	public static void stackOp() {
		System.out.println("Stack");
	    Stack<Integer> col = new Stack<Integer>();
	    
	    CollectionIteration.insert(col);
	    
	    CollectionIteration.iterateAll(col);
	    
	    System.out.printf("Popped   : %d\n", col.pop());
	    
	    CollectionIteration.iterate(col);
	    
	    
	    System.out.println();
	}
	
	public static void hashSetOp() {
		System.out.println("HashSet");
	    HashSet<Integer> col = new HashSet<Integer>();
	    
	    CollectionIteration.insert(col);
	    
	    CollectionIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	public static void linkedHashSetOp() {
		System.out.println("LinkedHashSet");
		LinkedHashSet<Integer> col = new LinkedHashSet<Integer>();

		CollectionIteration.insert(col);
	    
	    CollectionIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	
	public static void treeSetOp() {
		System.out.println("TreeSet");
		TreeSet<Integer> col = new TreeSet<Integer>();
		
		CollectionIteration.insert(col);
	    
	    CollectionIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	public static void hashMapOp() {
		System.out.println("HashMap");
	    HashMap<Integer, Integer> col = new HashMap<Integer, Integer>();
	    	    
	    MapIteration.insert(col);
	    
	    MapIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	public static void linkedHashMapOp() {
		System.out.println("LinkedHashMap");
		LinkedHashMap<Integer, Integer> col = new LinkedHashMap<Integer, Integer>();
	    
	    MapIteration.insert(col);
	    
	    MapIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	public static void treeMapOp() {
		System.out.println("TreeMap");
		TreeMap<Integer, Integer> col = new TreeMap<Integer, Integer>();
	    
	    MapIteration.insert(col);
	    
	    MapIteration.iterateAll(col);
	    
	    System.out.println();
	}
	
	
	
}

