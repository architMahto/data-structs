package comp2402a3;

public class Tester {

    public static <K> boolean testPart1(IntervalSet<Integer> dis) {
    	
    	Stopwatch timer = new Stopwatch();
    	
        // Your code goes here
    	for (int j = 2; j < 5; j++) {
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
    	
    	timer.start();
    	dis.add(new Interval<Integer>(0,2));
    	timer.stop();
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (dis.contains(0) && timer.elapsedSeconds() > 2)
    		return false;
    	
    	timer.start();
    	dis.add(new Interval<Integer>(5,8));
    	timer.stop();
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (!dis.contains(5) && timer.elapsedSeconds() > 2)
    		return false;
    	
    	timer.start();
    	dis.add(new Interval<Integer>(5,6));
    	timer.stop();
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (!dis.contains(5) && timer.elapsedSeconds() > 2)
    		return false;
    	
    	timer.start();
    	dis.add(new Interval<Integer>(6,7));
    	timer.stop();
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (!dis.contains(6) && timer.elapsedSeconds() > 2)
    		return false;
    	
    	timer.start();
    	dis.add(new Interval<Integer>(10,12));
    	timer.stop();
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (!dis.contains(10) && timer.elapsedSeconds() > 2)
    		return false;
    	
    	timer.start();
    	dis.add(new Interval<Integer>(1,2));
    	timer.stop();
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (timer.elapsedSeconds() > 2)
    		return false;
    	
    	timer.start();
    	dis.add(new Interval<Integer>(11,12));
    	timer.stop();
    	
    	System.out.println(dis);
    	
    	System.out.println("\n");
    	
    	if (timer.elapsedSeconds() > 2)
    		return false;
    	    	
        return true;
    }

    public static boolean testPart2(IntervalSet<Integer> dis) {
        // Your code goes here
    	for (int j = 2; j < 5; j++) {
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
    	
    	for (int j = 13; j < 17; j++) {
			Interval<Integer> i = new Interval<Integer>(j,j+1);
			dis.add(i);
    	}
    	
    	System.out.println(dis);
    	System.out.println("\n");
    	
    	for (int j = 20; j < 24; j++) {
			Interval<Integer> i = new Interval<Integer>(j,j+1);
			dis.add(i);
    	}
    	
    	System.out.println(dis);
    	System.out.println("\n");
    	
    	for (int j = 26; j < 30; j++) {
			Interval<Integer> i = new Interval<Integer>(j,j+1);
			dis.add(i);
    	}
    	
    	System.out.println(dis);
    	System.out.println("\n");
    	
    	Interval<Integer> int1 = new Interval<Integer>(8,22);
    	dis.add(int1);
    	
    	System.out.println("Adding " + int1 + " : \n");
    	System.out.println(dis);
    	System.out.println("\n");
    	
    	/*Interval<Integer> int2 = new Interval<Integer>(7,15);
    	dis.add(int2);
    	
    	System.out.println("Adding " + int2 + " : \n");
    	System.out.println(dis);
    	System.out.println("\n");
    	
    	Interval<Integer> int3 = new Interval<Integer>(0,2);
    	System.out.println("Adding " + int3 + " :");
    	dis.add(int3);
    	
    	//System.out.println(dis);
    	System.out.println("\n");*/
    	
        return true;
    }
    
    public static void main(String[] args) {
    	IntervalSet<Integer> dis = new DisjointIntervalSet<Integer>();
    	IntervalSet<Integer> ovr = new OverlappingIntervalSet<Integer>();
    	
    	System.out.println("----------------------");
    	System.out.println("Disjoint Interval Test");
    	System.out.println("----------------------\n");
    	
    	if (testPart1(dis)) 
    		System.out.println("Test(s) for Part 1 Passed!\n\n");
    	else 
    		System.out.println("Test(s) for Part 1 Failed!\n\n");
    	
    	System.out.println("-------------------------");
    	System.out.println("Overlapping Interval Test");
    	System.out.println("-------------------------\n");
    	
    	if (testPart2(ovr)) 
    		System.out.println("Test(s) for Part 2 Passed!\n\n");
    	else 
    		System.out.println("Test(s) for Part 2 Failed!\n\n");
    }
}
