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
    	
    	if (intervals.isEmpty() &&
    		(!(i.getA().compareTo(i.getB()) == 0))) {
    		intervals.add(i);
    		return true;
    	}
    	
    	SortedSet<Interval<K>> ts = intervals.tailSet(new Interval<>(i.getA(), i.getA()));
    	SortedSet<Interval<K>> hs = intervals.headSet(new Interval<>(i.getA(), i.getA()));
    	
    	if (hs.isEmpty()) {
    		if ((i.getA().compareTo(ts.first().getA()) < 0) &&
    			(!(i.getA().compareTo(i.getB()) == 0))) {
    			intervals.add(i);
                return true;
    		}
    	} else if (ts.isEmpty()) {
    		if (i.getA().compareTo(hs.last().getB()) >= 0 &&
    			(!(i.getA().compareTo(i.getB()) == 0))) {
    			intervals.add(i);
                return true;
    		}
    	} else {
    		if ((i.getA().compareTo(hs.last().getB()) >= 0) && 
    			(i.getA().compareTo(ts.first().getA()) < 0) &&
    			(i.getB().compareTo(ts.first().getA()) <= 0) &&
    			(!(i.getA().compareTo(i.getB()) == 0))) {
    			intervals.add(i);
                return true;
    		}
    	}
    	
    	return false;
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
