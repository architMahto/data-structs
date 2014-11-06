package comp2402a3;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class implements the IntervalSet interface for storing a set of
 * intervals, which may or may not be disjoint.
 *
 * @author morin
 *
 * @param <K>
 */
public class OverlappingIntervalSet<K extends Comparable<K>> implements IntervalSet<K> {

    SortedSet<Interval<K>> intervals;

    public OverlappingIntervalSet() {
        intervals = new TreeSet<>();
    }

    @Override
    public boolean add(Interval<K> i) {
        // TODO: Add code here
    	// Check if i overlaps with other intervals in set 
    	// Pick the min. value for a and the max. value for b
    	// when i overlaps with 2 or more intervals
    	
    	if (intervals.isEmpty()) {
        		intervals.add(i);
        		return true;
        } else {
        	SortedSet<Interval<K>> tsA = intervals.tailSet(new Interval<>(i.getA(), i.getA()));
        	SortedSet<Interval<K>> tsB = intervals.tailSet(new Interval<>(i.getB(), i.getB()));
        	
        	K iA = i.getA();
        	K iB = i.getB();
        	
        	if (tsA.isEmpty() && tsB.isEmpty()) {
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
        // TODO Add code for searching here.
    	SortedSet<Interval<K>> set = intervals.tailSet(new Interval<K>(x,x));
    	if (!set.isEmpty()) {
    		Interval<K> i = set.first();
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
        Tester.testPart2(new OverlappingIntervalSet<Integer>());
    }

}
