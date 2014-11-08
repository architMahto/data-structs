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
        	Interval<K> newInt = null;
        	
        	K iA = i.getA(), iB = i.getB();
        	
        	if (tsA.isEmpty() && tsB.isEmpty()) {
        		// if both tail sets are empty
        		K hsALastA = hsA.last().getA();
        		K hsALastB = hsA.last().getB();
        		
        		if (iA.compareTo(hsALastB) <= 0) {
        			// if iA overlaps with last element of headset from iA
        			hsA.remove(hsA.last());
        			newInt = new Interval<>(hsALastA,iB);
        		} else {
        			// if iA doesn't overlap with last element of headset from iA
        			newInt = i;
        		}
        		intervals.add(newInt);
    			return true;
        	} else if (!tsA.isEmpty() && tsB.isEmpty()) {
        		// if tailset from iA is not empty and tailset from iB is empty
        		K tsAfirstA = tsA.first().getA();
        		
        		tsA.clear();
        		
        		if (hsA.isEmpty()) {
        			// if headset from iA is empty
        			newInt = i;
        		} else {
        			// if headset from iA is not empty
            		K hsAlastA = hsA.last().getA();
            		K hsAlastB = hsA.last().getB();
        			
            		if (iA.compareTo(tsAfirstA) < 0 && iA.compareTo(hsAlastB) > 0) {
            			// if iA doesn't overlap with first interval of tailset from iA & iA doesn't overlap with last interval of headset from iA
            			newInt = i;
            		} else if (iA.compareTo(tsAfirstA) < 0 && iA.compareTo(hsAlastB) <= 0) {
            			// if iA doesn't overlap with first interval of tailset from iA & iA overlaps with last interval of headset from iA
            			hsA.remove(hsA.last());
            			newInt = new Interval<>(hsAlastA,iB);
            		} else if (iA.compareTo(tsAfirstA) >= 0) {
            			// if iA overlaps with first interval of tailset from iA
            			newInt = new Interval<>(tsAfirstA,iB);
            		}
        		}
        		intervals.add(newInt);
    			return true;
        	} else if (!tsA.isEmpty() && !tsB.isEmpty()) {
        		// if both tail sets are empty
        		K tsAfirstA = tsA.first().getA();
        		K tsBfirstA = tsB.first().getA();
        		K tsBfirstB = tsB.first().getB();
        		K firstIntervalA = intervals.first().getA();
        		        		
        		if (hsA.isEmpty()) {
        			// if head set from A is empty
        			if (tsBfirstB.compareTo(firstIntervalA) < 0) {
        				// if i is dijoint from intervals
        				newInt = i;
        			} else if (tsBfirstB.compareTo(firstIntervalA) >= 0 && iB.compareTo(tsBfirstA) < 0) {
        				// if iB doesn't overlap with tailset from B
        				symDifferenceTailSetAB(tsA,tsB);
        				newInt = i;
        			} else if (tsBfirstB.compareTo(firstIntervalA) >= 0 && iB.compareTo(tsBfirstA) >= 0) {
        				// if iB overlaps with tailset from B			
        				symDifferenceTailSetAB(tsA,tsB);
            			tsB.remove(tsB.first());
            			newInt = new Interval<K>(iA,tsBfirstB);
        			}
            	} else  {
       		
            		K hsAlastA = hsA.last().getA();
        			K hsAlastB = hsA.last().getB();
        			
        			symDifferenceTailSetAB(tsA,tsB);
        			
        			if (iA.compareTo(tsAfirstA) < 0 && iB.compareTo(tsBfirstA) < 0) {
        				// if iA doesn't overlap with first interval of tailset from A & iB doesn't overlap with first interval of tailset from B
        				if (iA.compareTo(hsAlastB) <= 0) {
        					hsA.remove(hsA.last());
        					newInt = new Interval<K>(hsAlastA,iB);
        				} else {
        					newInt = i;
        				}
        			} else if (iA.compareTo(tsAfirstA) < 0 && iB.compareTo(tsBfirstA) >= 0) {
        				// if iA doesn't overlap with first interval of tailset from A & iB overlaps with first interval of tailset from B
        				tsB.remove(tsB.first());
        				if (iA.compareTo(hsAlastB) <= 0) {
        					hsA.remove(hsA.last());
        					newInt = new Interval<K>(hsAlastA,tsBfirstB);
        				} else {
        					newInt = new Interval<K>(iA,tsBfirstB);
        				}
        			} else if (iA.compareTo(tsAfirstA) >= 0 && iB.compareTo(tsBfirstA) < 0) {
        				// if iA overlaps with first interval of tailset from A & if iB doesn't overlap with first interval of tailset from B
        				newInt = new Interval<K>(tsAfirstA,iB);
        			} else if (iA.compareTo(tsAfirstA) >= 0 && iB.compareTo(tsBfirstA) >= 0) {
        				// if iA overlaps with first interval of tailset from A & if iB overlaps with first interval of tailset from B
        				tsB.remove(tsB.first());
        				newInt = new Interval<K>(tsAfirstA,tsBfirstB);
        			}
            	}
        		intervals.add(newInt);
				return true;
        	}
        }
        return false;
    }

    // remove all elements sets A and B have in common
    public void symDifferenceTailSetAB (SortedSet<Interval<K>> setA, SortedSet<Interval<K>> setB) {
    	
    	Iterator<Interval<K>> setAItr = setA.iterator();
    	
    	while (setAItr.hasNext()) {
			Interval<K> currentInterval = setAItr.next();
			if (currentInterval.compareTo(setB.first()) == 0) 
				break;
			setAItr.remove();
		}
    }
    
	@Override
    public void clear() {
        intervals.clear();
    }

    @Override
    public boolean contains(K x) {
        // TODO Add code for searching here.
    	SortedSet<Interval<K>> ts = intervals.tailSet(new Interval<K>(x,x));
    	if (!ts.isEmpty()) {
    		SortedSet<Interval<K>> tsN = ts.tailSet(new Interval<K>(ts.first().getB(),ts.first().getB()));
    		Interval<K> i = ts.first();
    		if (i.contains(x))
    			return true;
    		
    		if (!tsN.isEmpty() && tsN.first().getA().equals(x))
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
