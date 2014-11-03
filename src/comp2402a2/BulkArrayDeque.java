package comp2402a2;

import java.util.Collection;

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

		T[] b = f.newArray(Math.max(2*n + c.size(), 1));
		
		//re-assigning elements before the collection
		for (int k = 0; k < i; k++) {
			b[k] = a[(j+k % a.length)];
			j = 0;
		}
		
		// adding elements from the collection
		for (T x : c) {
			b[i] = x;
			i++;
		}
		
		// re-assigning elements after the collection
		for (int k = i; k < a.length; k++) 
			b[k] = a[(j+(k-c.size()) % a.length)];
		
		a = b;
		n += c.size();

		return true;
	}
	
    public static void main(String[] args) {
        if (!Tester.testPart2(new BulkArrayDeque<Integer>(Integer.class))) {
            System.err.println("Test failed!");
            System.exit(-1);
        }
    }
}
