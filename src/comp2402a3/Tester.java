package comp2402a3;

public class Tester {

    public static <K> boolean testPart1(IntervalSet<Integer> dis) {
        // Your code goes here
    	for (int j = 0; j < 5; j++) {
			Interval<Integer> i = new Interval<Integer>(j,j+1);
			dis.add(i);
    	}
    	
    	System.out.println(dis);
    	    	
    	System.out.println("\n");
    	
    	for (int j = 7; j < 10; j++) {
			Interval<Integer> i = new Interval<Integer>(j,j+1);
			dis.add(i);
    	}
    	
    	System.out.println(dis);
    	    	
    	System.out.println("\n");
    	
    	dis.add(new Interval<Integer>(6,8));
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (dis.contains(6))
    		return false;
    	
    	dis.add(new Interval<Integer>(6,7));
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (!dis.contains(6))
    		return false;
    	
    	dis.add(new Interval<Integer>(5,6));
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (!dis.contains(5))
    		return false;
    	    	
        return true;
    }

    public static boolean testPart2(IntervalSet<Integer> dis) {
        // Your code goes here
    	for (int j = 0; j < 5; j++) {
    		for (int k = j + 1; k < 6; k++) {
    			Interval<Integer> i = new Interval<Integer>(j,k);
    			dis.add(i);
    		}
    	}
    	
    	System.out.println(dis);
    	System.out.println("\n");
    	
    	dis.add(new Interval<Integer>(5,6));
    	
    	System.out.println(dis);
    	System.out.println("\n");
    	
        return true;
    }
    
    public static void main(String[] args) {
    	IntervalSet<Integer> dis = new DisjointIntervalSet<Integer>();
    	IntervalSet<Integer> ovr = new OverlappingIntervalSet<Integer>();
    	
    	/*if (testPart1(dis)) 
    		System.out.println("Test(s) for Part 1 Passed!");
    	else 
    		System.out.println("Test(s) for Part 1 Failed!");*/
    	
    	if (testPart2(ovr)) 
    		System.out.println("Test(s) for Part 1 Passed!");
    	else 
    		System.out.println("Test(s) for Part 1 Failed!");
    }
}
