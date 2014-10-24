package comp2402a3;

public class Tester {

    public static boolean testPart1(IntervalSet<Integer> dis) {
        // Your code goes here
    	for (int j = 0; j < 10; j++) {
    		for (int k = 0; k < 10; k++) {
    			Interval i = new Interval(j,k);
    			dis.add(i);
    		}
    	}
    	dis.add(new Interval(20,20));
        return false;
    }

    public static boolean testPart2(IntervalSet<Integer> dis) {
        // Your code goes here
    	for (int j = 0; j < 10; j++) {
    		for (int k = 0; k < 10; k++) {
    			Interval i = new Interval(j,k);
    			dis.add(i);
    		}
    	}
        return false;
    }
}
