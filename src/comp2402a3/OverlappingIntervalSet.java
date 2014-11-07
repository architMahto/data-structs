package comp2402a3;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

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
        	Iterator<Interval<K>> tsAItr = tsA.iterator();
        	
        	K iA = i.getA();
        	K iB = i.getB();
        	
        	if (tsA.isEmpty() && tsB.isEmpty()) {
        		// if both tail sets are empty
        		K hsALastA = hsA.last().getA();
        		K hsALastB = hsA.last().getB();
        		
        		if (iA.compareTo(hsALastB) <= 0) {
        			// if iA overlaps with last element of headset from iA
        			hsA.remove(hsA.last());
        			intervals.add(new Interval<>(hsALastA,iB));
        			return true;
        		} else {
        			// if iA doesn't overlap with last element of headset from iA
        			intervals.add(i);
        			return true;
        		}
        	} else if (!tsA.isEmpty() && tsB.isEmpty()) {
        		// if tailset from iA is not empty and tailset from iB is empty
        		if (hsA.isEmpty()) {
        			// if headset from iA is empty
        			tsA.clear();
        			intervals.add(i);
        			return true;
        		} else {
        			// if headset from iA is not empty
        			K hsAlastA = hsA.last().getA();
            		K hsAlastB = hsA.last().getB();
            		K tsAfirstA = tsA.first().getA();
        			
        			if (iA.compareTo(tsAfirstA) < 0) {
        				// if iA doesn't overlap with first interval of tailset from iA
        				if (iA.compareTo(hsAlastB) > 0) {
        					// if iA doesn't overlap with last interval of headset from iA
        					tsA.clear();
                			intervals.add(i);
                			return true;
        				} else {
        					// if iA overlaps with last interval of headset from iA
        					tsA.clear();
        					hsA.remove(hsA.last());
                			intervals.add(new Interval<>(hsAlastA,iB));
                			return true;
        				}
        			} else {
        				// if iA overlaps with first interval of tailset from iA
    					tsA.clear();
            			intervals.add(new Interval<>(tsAfirstA,iB));
            			return true;
        			}
        		}
        	} else if (!tsA.isEmpty() && !tsB.isEmpty()) {
        		// if both tail sets are empty
        		K tsBfirstA = tsB.first().getA();
        		K tsBfirstB = tsB.first().getB();
        		
        		if (hsA.isEmpty() && hsB.isEmpty()) {
        			// if both headsets are empty
        			if (iB.compareTo(tsBfirstA) >= 0) {
        				// iB overlaps first interval of tailset from B
        				tsB.remove(tsB.first());
            			intervals.add(new Interval<>(iA,tsBfirstB));
            			return true;
        			} else {
        				// iB doesn't overlap first interval of tailset from B
	            		intervals.add(i);
	            		return true;
        			}
            	} else if (hsA.isEmpty() && !hsB.isEmpty()) {
            		// if headset from iA is empty and headset from iB is not empty
            		if (tsB.first().contains(iB)) {
            			// if iB overlaps first interval of tailset from B
            			hsB.clear();
            			tsB.remove(tsB.first());
            			intervals.add(new Interval<K>(iA,tsBfirstB));
            			return true;
            		} else {
            			// if iB doesn't overlap with first interval from tailset of B
            			hsB.clear();
            			intervals.add(i);
            			return true;
            		}
            	} else if (!hsA.isEmpty() && !hsB.isEmpty()) {
            		// if both head sets are not empty
            		K hsAlastA = hsA.last().getA();
        			K hsAlastB = hsA.last().getB();
        			
        			while (tsAItr.hasNext()) {
        				tsAItr.next();
        				if (tsAItr.next().compareTo(tsB.first()) == 0)
        					break;
        				tsAItr.remove();
        			}
        			
        			System.out.println ("\n" + "New Tail Set from A: " + tsA + "\n");
            		
            		if (iA.compareTo(hsAlastB) <= 0) {
            			// if iA overlaps with last interval of head set
            			if (iB.compareTo(tsBfirstA) < 0) {
            				// if iB doesn't overlap with first interval of tail set
	            			hsA.remove(hsA.last());
	            			intervals.add(new Interval<>(hsAlastA,iB));
	            			return true;
            			} else {
            				// if iB overlaps with first interval of tail set
            				hsA.remove(hsA.last());
	            			tsB.remove(tsB.first());
	            			intervals.add(new Interval<>(hsAlastA,tsBfirstB));
	            			return true;
            			}
            		} else {
            			// if iA doesn't overlap with last interval of head set
            			if (iB.compareTo(tsBfirstA) < 0) {
            				// if iB doesn't overlap with first interval of tail set
	            			hsA.remove(hsA.last());
	            			intervals.add(i);
	            			return true;
            			} else {
            				// if iB overlaps with first interval of tail set
            				hsA.remove(hsA.last());
            				tsB.remove(tsB.first());
	            			intervals.add(new Interval<>(iA,tsBfirstB));
	            			return true;
            			}
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
