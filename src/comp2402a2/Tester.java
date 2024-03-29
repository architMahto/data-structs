package comp2402a2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tester {

    public static boolean testPart1(Queue<Integer> q) {
        // Your code goes here
    	Stopwatch timer = new Stopwatch();
    	
    	timer.start();
    	for (int i = 0; i < 20; i++) {q.offer(i);}
    	timer.stop();
    	if (timer.elapsedSeconds() > 2) {return false;}
    	
    	int same = 0, different = 0;
    	
    	for (int k = 0; k < 10; k++) {
    		q.offer(k*20);
    		if (q.poll() == k*20) {same++;} 
    		else {different++;}
    	}
    	    	

		return true;
    }

    public static boolean testPart2(List<Integer> ad) {
        // Your code goes here
    	Stopwatch timer = new Stopwatch();

    	for (int i = 0; i < 20; i++) {
    		ad.add(i);
    		System.out.println(ad.get(i));
    	}
    	    	
    	List<Integer> tens = new ArrayList<Integer>();
    	for (int j = 1; j <= 4; j++) 
    		tens.add(j*10);
    	
    	System.out.println("\n");
    	
    	//TODO - test for correctness
    	
    	// test 1
    	System.out.println("Test 1: ");
    	timer.start();
    	ad.addAll(4, tens);
    	timer.stop();
    	for (int i = 0; i < ad.size(); i++) {
    		System.out.println(ad.get(i));
    	}
    	if (timer.elapsedSeconds() > 2) 
    		return false;
    	
    	System.out.println("\n");
    	
    	// test 2
    	System.out.println("Test 2: ");
    	timer.start();
    	ad.addAll(12, tens);
    	timer.stop();
    	for (int l = 0; l < ad.size(); l++) 
    		System.out.println(ad.get(l));
    	if (timer.elapsedSeconds() > 2) 
    		return false;
    	
    	System.out.println("\n");
    	
		return true;
    }

    public static boolean testPart3(List<Integer> ad) {
        // Your code goes here
    	Stopwatch timer = new Stopwatch();

    	for (int i = 0; i < 10; i++) {ad.add(i,i);}
    	
    	System.out.println(ad + "\n");
    	
    	//test 1
    	timer.start();
    	ad.add(5,30);
    	timer.stop();    	
    	if (timer.elapsedSeconds() > 2) {return false;}
    	if (ad.get(5) != 30) {return false;}
    	
    	/*/ test 2
    	timer.start();
    	ad.add(15,2000000);
    	timer.stop();    	
    	if (timer.elapsedSeconds() > 2) {return false;}
    	if (ad.get(15) != 1000) {return false;}/*/

    	
    	return true;
    }
    
    public static boolean testPart5(List<Integer> ras) {
        // Your code goes here
    	Stopwatch timer = new Stopwatch();
    	
    	System.out.println("Original Rootish Array Stack: \n");

    	for (int i = 0; i < 15; i++) {
    		ras.add(i);
    		System.out.println(ras.get(i));
    	}
    	
    	System.out.println("\n");
    	
    	//test 1
    	timer.start();
    	ras.add(0,30);
    	timer.stop();
    	
    	System.out.println("Modified Rootish Array Stack: \n");
    	
    	for (int i = 0; i < ras.size(); i++) {
    		System.out.println(ras.get(i));
    	}
    	
    	System.out.println("\n");
    	
    	System.out.println("Part 5 took " + timer.elapsedSeconds() + "\n");
    	if (timer.elapsedSeconds() > 2) {return false;}
    	
    	
    	//System.out.println("\n");
    	
    	/*/ test 1
    	timer.start();
    	ras.add(5,2000000);
    	timer.stop();
    	if (ras.get(5) != 2000000) {return false;}

    	if (timer.elapsedSeconds() > 2) {return false;}/*/

    	
    	return true;
    }
    
    public static void main(String[] args)
    {

    	RandomQueue<Integer> q = new RandomQueue<Integer>();
    	BulkArrayDeque<Integer> ad = new BulkArrayDeque<Integer>(Integer.class);
    	ArrayDeque2<Integer> ad2 = new ArrayDeque2<Integer>(Integer.class);
    	ArrayDeque3<Integer> ad3 = new ArrayDeque3<Integer>(Integer.class);
    	RootishArrayStack2<Integer> ras = new RootishArrayStack2<Integer>(Integer.class);
    	

    	/*if (testPart1(q)) 
    		System.out.println("Test(s) for Part 1 Passed!");
    	else 
    		System.out.println("Test(s) for Part 1 Failed!");*/
    	
    	/*if (testPart2(ad)) 
    		System.out.println("Test(s) for Part 2 Passed!");
    	else 
    		System.out.println("Test(s) for Part 2 Failed!");*/
    	
    	/*if (testPart3(ad2)) 
    	 	System.out.println("Test(s) for Part 3 Passed");
    	else
    		System.out.println("Test(s) for Part 3 Failed!");*/
    	
    	/*if (testPart3(ad3)) 
    		System.out.println("Test(s) for Part 4 Passed");
		else
			System.out.println("Test(s) for Part 4 Failed!");*/
    	
    	if (testPart5(ras)) 
    		System.out.println("Test(s) for Part 5 Passed!");
    	else 
    		System.out.println("Test(s) for Part 5 Failed!");

    }
}
