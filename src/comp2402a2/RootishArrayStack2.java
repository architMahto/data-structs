package comp2402a2;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * This class implements the List interface using a collection of arrays of
 * sizes 1, 2, 3, 4, and so on.  The main advantages of this over an 
 * implementation like ArrayList is that there is never more than O(sqrt(size())
 * space being used to store anything other than the List elements themselves.
 * Insertions and removals take O(size() - i) amortized time.
 * 
 * This provides a space-efficient implementation of an ArrayList.  
 * The total space used beyond what is required to store elements is O(sqrt(n)) 
 * @author morin
 *
 * @param <T> the type of objects stored in this list
 */
public class RootishArrayStack2<T> extends AbstractList<T> {
	/**
	 * The type of objects stored in this list
	 */
	Factory<T> f;
	
	/*
	 * The blocks that contains the list elements
	 */
	List<BDeque<T>> blocks;
	
	/**
	 * The number of elements in the list
	 */
	int n;

    /**
     * Implement an assertion
     */     
	protected static void myassert(boolean b) throws AssertionError {
		if (!b) {
			throw new AssertionError();
		}
	}

	/**
	 * Convert a list index i into a block number
	 * @param i
	 * @return the index of the block that contains list
	 *         element i
	 */
	 protected static int i2b(int i) {
		double db = (-3.0 + Math.sqrt(9 + 8*i)) / 2.0;
		int b = (int)Math.ceil(db);
		return b; 
	}
	
	protected void grow() {
		blocks.add(new BDeque<T>(blocks.size()+1, f.type()));
	}
	
	protected void shrink() {
		int r = blocks.size();
		while (r > 0 && (r-2)*(r-1)/2 >= n) {
			blocks.remove(blocks.size()-1);
			r--;
		}
	}
	
	public T get(int i) {
		if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
		int b = i2b(i);
		int j = i - b*(b+1)/2;
		return blocks.get(b).get(j);
	}

	public T set(int i, T x) {
		if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
		int b = i2b(i);
		int j = i - b*(b+1)/2;
		T y = blocks.get(b).get(j);
		blocks.get(b).set(j,x);
		return y;
	}
	
	/**
	 * TODO: This is too slow - you need to speed it up
	 */
	public void add(int i, T x) {
		if (i < 0 || i > n) throw new IndexOutOfBoundsException();
		int r = blocks.size();
		if (r*(r+1)/2 < n + 1) grow();
		blocks.get(blocks.size()-1).add(null);
		n++;
		int b = i2b(i);
		int c = i - b*(b+1)/2;
		  
		T temp;
		if (b == blocks.size()-1) {
		  for (int j = blocks.get(b).size()-1; j > c; j--) {
		    set(j, get(j-1));
		  }
		}
		else {
		  temp = blocks.get(b).get(blocks.get(b).size()-1);
		  for (int j = blocks.get(b).size()-1; j > c; j--) {
		    blocks.get(b).set(j, blocks.get(b).get(j-1));
		  }
		  for (int j = blocks.size()-1; j > b; j--) {
		    if (j-1 == b) {
		      blocks.get(j).pushFront(temp);
		      break;
		    }
		    blocks.get(j).pushFront(blocks.get(j-1).popBack());
		  }
		}
		set(i, x);
	}
	
	/**
	 * TODO: This is too slow - you need to speed it up
	 */
	public T remove(int i) {
		if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
		T x = null, y = null;
		int b = i2b(i);
		int j = i - b*(b+1)/2;
		if (j < blocks.get(b).size()/2) {
			x = get(i);
			if (i == 0) 
			for (int k = j; k > 0; k--)
				set(k,get(k-1));
			y = blocks.get(b).popFront();
		} else {
			x = get(i);
			for (int k = j; k < blocks.get(b).size() - 1;k++)
				set(k,get(k+1));
			y = blocks.get(b).popBack();
		}
		n--;
		int r = blocks.size();
		if ((r-2)*(r-1)/2 >= n)	shrink();
		return x;
	}

	public int size() {
		return n;
	}

	public RootishArrayStack2(Class<T> t) {
		f = new Factory<T>(t);
		n = 0;
		blocks = new ArrayList<BDeque<T>>();
	}
	
	public void clear() {
		blocks.clear();
		n = 0;
	}
	
	protected static <T> boolean listEquals(List<T> l1, List<T> l2) {
		if (l1.size() != l2.size()) {
			return false;
		}
		Iterator<T> i1 = l1.iterator();
		Iterator<T> i2 = l2.iterator();
		while (i1.hasNext()) {
			if (! i1.next().equals(i2.next())) {
				return false;
			}
		}
		return true;
	}
	
    public static void main(String[] args) {
        if (!Tester.testPart5(new RootishArrayStack2<Integer>(Integer.class))) {
            System.err.println("Test failed!");
            System.exit(-1);
        }
    }
}
