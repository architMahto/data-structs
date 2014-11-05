package comp2402a3;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class implements the IntervalSet interface for storing a set of disjoint
 * intervals
 *
 * @author morin
 *
 * @param <K>
 */
public class DisjointIntervalSet<K extends Comparable<K>> implements IntervalSet<K> {

    SortedSet<Interval<K>> intervals;

    public DisjointIntervalSet() {
        intervals = new TreeSet<>();
    }

    @Override
    public boolean add(Interval<K> i) {
        // TODO: add checking to see if i overlaps anything in the set -- if so,
        //       don't add it and return false. Otherwise, add it and return true
    	
    	if (intervals.isEmpty()) {
    		// add to an empty set
    		intervals.add(i);
    		return true;
    	} else {
	    	SortedSet<Interval<K>> ts = intervals.tailSet(new Interval<>(i.getA(), i.getA()));
	    	SortedSet<Interval<K>> hs = intervals.headSet(new Interval<>(i.getA(), i.getA()));
	    	
	    	if (hs.isEmpty()) {
	    		// adding at the beginning
	    		if (i.getB().compareTo(ts.first().getA()) <= 0) {
	    			intervals.add(i);
	                return true;
	    		} else {
    				return false;
    			}
	    	} else if (ts.isEmpty()) {
	    		// adding at the end
	    		if (i.getA().compareTo(hs.last().getB()) >= 0) {
	    			intervals.add(i);
	                return true;
	    		} else {
	    			return false;
	    		}
	    	} else {
	    		// adding in the middle
	    		if (i.getA().compareTo(hs.last().getB()) >= 0) {
	    			if (i.getB().compareTo(ts.first().getA()) <= 0) {
		    			intervals.add(i);
		                return true;
	    			} else {
	    				return false;
	    			}
	    		} else {
	    			return false;
	    		}
	    	}
        }
    	
    }

    @Override
    public void clear() {
        intervals.clear();
    }

    @Override
    public boolean contains(K x) {
        // TODO Add code for searching here.  See Interval.main() for an example
    	for (Interval<K> i : intervals) {
    		if (i.contains(x))
    			return true;
    	}
        return false;
    }

    @Override
    public String toString() {
        return intervals.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Tester.testPart1(new DisjointIntervalSet<Integer>());
    }

}
