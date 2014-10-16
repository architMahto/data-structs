package comp2402a2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class BulkArrayDeque<T> extends ArrayDeque<T> {
	
	public BulkArrayDeque(Class<T> clazz) {
		super(clazz);
	}
	
	/**
	 * Add all the elements of c to this array deque, starting
	 * at position i
	 * @param i
	 * @param c
	 */
	public boolean addAll(int i, Collection<? extends T> c) {
		// this implementation is too slow 
		//  make it run in O(c.size()+n-i) time.
		T[] a = f.newArray(Math.max(2*n + c.size(), 1));
		for (int j = 0; j < i; j++) {}
		
		for (T x : c)
			add(i++, x);
		
		for (int k = i; k < a.length; k++) {}			
		
		return true;
	}
	
	
    public static void main(String[] args) {
        if (!Tester.testPart2(new BulkArrayDeque<Integer>(Integer.class))) {
            System.err.println("Test failed!");
            System.exit(-1);
        }
    }
}
