package comp2402a3;

public class Tester {

    public static <K> boolean testPart1(IntervalSet<Integer> dis) {
    	
    	Stopwatch timer = new Stopwatch();
    	
    	System.out.println("----------------------");
    	System.out.println("Disjoint Interval Test");
    	System.out.println("----------------------\n");
    	
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
    	Stopwatch timer = new Stopwatch();
    	
    	System.out.println("-------------------------");
    	System.out.println("Overlapping Interval Test");
    	System.out.println("-------------------------\n");
    	
    	System.out.println("Adding elements... \n");
    	for (int i = 2; i < 5; i++) {

    		Interval<Integer> newInt = new Interval<Integer>(i,i+1);
    		timer.start();
	    	dis.add(newInt);
	    	timer.stop();
	    	System.out.println(newInt + " : " + timer.elapsedSeconds() + " s");
    	}	
    	for (int i = 7; i < 10; i++) {
    		Interval<Integer> newInt = new Interval<Integer>(i,i+1);
    		timer.start();
	    	dis.add(newInt);
	    	timer.stop();
	    	System.out.println(newInt + " : " + timer.elapsedSeconds() + " s");
    	}
    	for (int i = 13; i < 17; i++) {
    		Interval<Integer> newInt = new Interval<Integer>(i,i+1);
    		timer.start();
	    	dis.add(newInt);
	    	timer.stop();
	    	System.out.println(newInt + " : " + timer.elapsedSeconds() + " s");
    	}
    	for (int i = 20; i < 24; i++) {
    		Interval<Integer> newInt = new Interval<Integer>(i,i+1);
    		timer.start();
	    	dis.add(newInt);
	    	timer.stop();
	    	System.out.println(newInt + " : " + timer.elapsedSeconds() + " s");
    	}
    	for (int i = 26; i < 30; i++) {
    		Interval<Integer> newInt = new Interval<Integer>(i,i+1);
    		timer.start();
	    	dis.add(newInt);
	    	timer.stop();
	    	System.out.println(newInt + " : " + timer.elapsedSeconds() + " s");
    	}
    	System.out.println("\n");
    	
    	System.out.println(dis);
    	System.out.println("\n");
    	
    	Interval<Integer> newInt = new Interval<Integer>(10,13);
    	
    	System.out.println("Done. Adding test element " + newInt + " ...\n");
    	
    	timer.start();
    	dis.add(newInt);
    	timer.stop();
    	
    	System.out.println(timer.elapsedSeconds() + " s\n");
    	
    	System.out.println(dis);
    	System.out.println("\n");
    	System.out.println("Finished");
    	System.out.println("\n");
    	
    	for (int i = 0; i < 31; i++)
    		System.out.println(i + " " + dis.contains(i));
    	
    	System.out.println("\n");
        return true;
    }
    
    public static void main(String[] args) {
    	IntervalSet<Integer> dis = new DisjointIntervalSet<Integer>();
    	IntervalSet<Integer> ovr = new OverlappingIntervalSet<Integer>();
    	
    	if (testPart1(dis)) 
    		System.out.println("Test(s) for Part 1 Passed!\n\n");
    	else 
    		System.out.println("Test(s) for Part 1 Failed!\n\n");
    	
    	if (testPart2(ovr)) 
    		System.out.println("Test(s) for Part 2 Passed!\n\n");
    	else 
    		System.out.println("Test(s) for Part 2 Failed!\n\n");
    }
}
