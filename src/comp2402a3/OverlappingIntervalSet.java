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
        	SortedSet<Interval<K>> hsA = intervals.headSet(new Interval<>(i.getA(), i.getA()));
        	SortedSet<Interval<K>> hsB = intervals.headSet(new Interval<>(i.getB(), i.getB()));
        	
        	K iA = i.getA();
        	K iB = i.getB();
        	
        	if (tsA.isEmpty() && tsB.isEmpty()) {
        		K hsALastA = hsA.last().getA();
        		K hsALastB = hsA.last().getB();
        		
        		if (iA.compareTo(hsALastB) <= 0) {
        			hsA.remove(hsA.last());
        			intervals.add(new Interval<>(hsALastA,iB));
        			return true;
        		} else {
        			intervals.add(i);
        			return true;
        		}
        	} else if (!tsA.isEmpty() && tsB.isEmpty()) {
        		if (hsA.isEmpty()) {
        			tsA.clear();
        			intervals.add(i);
        			return true;
        		} else {
        			K hsAlastA = hsA.last().getA();
            		K hsAlastB = hsA.last().getB();
            		K tsAfirstA = tsA.first().getA();
        			
        			if (iA.compareTo(tsAfirstA) < 0) {
        				if (iA.compareTo(hsAlastB) > 0) {
        					tsA.clear();
                			intervals.add(i);
                			return true;
        				} else {
        					tsA.clear();
        					hsA.remove(hsA.last());
                			intervals.add(new Interval<>(hsAlastA,iB));
                			return true;
        				}
        			} else {
    					tsA.clear();
            			intervals.add(new Interval<>(tsAfirstA,iB));
            			return true;
        			}
        		}
        	} else if (!tsA.isEmpty() && !tsB.isEmpty()) {
        		K tsBB = tsB.first().getB();
        		
        		System.out.println("\n");
        		System.out.println("Head Set of A: " + hsA);
        		System.out.println("\n");
        		System.out.println("Head Set of B: " + hsB);
        		System.out.println("\n");
        		System.out.println("Tail Set of B: " + tsB);
        		System.out.println("\n");
        		
        		if (hsA.isEmpty() && hsB.isEmpty()) {
            		intervals.add(i);
            		return true;
            	} else if (hsA.isEmpty() && !hsB.isEmpty()) {
            		if (tsB.first().contains(iB)) {
            			System.out.println("Clearing " + hsB + ": \n");
            			hsB.clear();
            			System.out.println("Removing " + tsB.first() + ": \n");
            			tsB.remove(tsB.first());
            			Interval<K> newInt = new Interval<K>(iA,tsBB);
            			System.out.println("Adding " + newInt + ": \n");
            			intervals.add(newInt);
            			System.out.println(intervals);
            			return true;
            		} else {
            			System.out.println("Clearing " + hsB + ": \n");
            			hsB.clear();
            			System.out.println("Adding " + i + ": \n");
            			intervals.add(i);
            			System.out.println(intervals);
            			return true;
            		}
            	}
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
