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
        return false;
    }

    @Override
    public void clear() {
        intervals.clear();
    }

    @Override
    public boolean contains(K x) {
        // TODO Add code for searching here.  See Interval.main() for an example
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
        Tester.testPart1(new DisjointIntervalSet<>());
    }

}
