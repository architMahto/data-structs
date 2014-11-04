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
    	if (intervals.isEmpty() &&
        		(!(i.getA().compareTo(i.getB()) == 0))) {
        		intervals.add(i);
        		return true;
        } else {
        	SortedSet<Interval<K>> hs = intervals.headSet(new Interval<>(i.getA(), i.getA()));
        	SortedSet<Interval<K>> ts = intervals.tailSet(new Interval<>(i.getA(), i.getA()));
        	
        	if (ts.isEmpty()) {
        		if (i.getA().compareTo(hs.last().getB()) <= 0 &&
        			i.getB().compareTo(hs.last().getB()) > 0) {
        			intervals.clear();
        			intervals.add(new Interval<>(hs.last().getA(),i.getB()));
        		} else if (i.getA().compareTo(hs.last().getB()) > 0) {
        			intervals.add(i);
        		}
    			return true;
        	} else if (hs.isEmpty()) {
        		if (i.getA().compareTo(ts.first().getA()) < 0) {
        			if (i.getB().compareTo(ts.first().getB()) <= 0) {
        				if (i.getB().compareTo(ts.first().getA()) < 0) {
        					intervals.add(i);
        				} else {
        					intervals.clear();
        					intervals.add(new Interval<>(i.getA(),ts.first().getB()));
        				}
        			} else {
        				intervals.clear();
        				intervals.add(i);
        			}
        			ts.clear();
        		} else if (i.getA().compareTo(ts.first().getA()) == 0) {
        			if (i.getB().compareTo(ts.first().getB()) > 0) {
        				intervals.clear();
        				intervals.add(new Interval<>(ts.first().getA(),i.getB()));
        			}
        		}
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
        Tester.testPart2(new OverlappingIntervalSet<Integer>());
    }

}
