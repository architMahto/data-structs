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
  	  SortedSet<Interval<K>> tsA = intervals.tailSet(new Interval<K>(i.getA(),i.getA()));  
  	  K iA = i.getA(), iB = i.getB();
  		  Iterator<Interval<K>> tsAItr = tsA.iterator();
  			if (!tsA.isEmpty()) { 
  				Interval<K> first = tsA.first();
  				if (first.compareTo(i) == 0 && first.getA().compareTo(iA) <= 0) 
  					  iA = first.getA();
  				
  				while(tsAItr.hasNext())
  				{
  					Interval<K> next = tsAItr.next();
  					if (next.compareTo(i) == 0) {
  						if(next.getB().compareTo(iB) >= 0)
  						{
  							iB = next.getB();
  							tsAItr.remove();
  							break;
  						} else {
  							tsAItr.remove();
  						}
  					} else {
  						break;
  					}
  				}
  			}
  			intervals.add(i);
  			return true;
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
    		if (i.contains(x)){
    			return true;
    		}
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
