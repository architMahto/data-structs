package comp2402a2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tester {

    public static boolean testPart1(Queue<Integer> q) {
        // Your code goes here
    	Stopwatch timer = new Stopwatch();
    	
    	for (int i = 0; i < 1000000; i++) {q.offer(i);}
    	
    	timer.start();
    	System.out.println(q.peek());
    	timer.stop();    	
    	if (timer.elapsedSeconds() > 2) {return false;}
    	
		return true;
    }

    public static boolean testPart2(List<Integer> ad) {
        // Your code goes here
    	Stopwatch timer = new Stopwatch();
    	
    	for (int i = 0; i < 1000000; i++) {ad.add(i);}
    	
    	List<Integer> tens = new ArrayList<Integer>();
    	for (int j = 0; j < 1000; j++) {tens.add(j*10);}
    	
    	// test 1
    	timer.start();
    	ad.addAll(4, tens);
    	timer.stop();
    	if (timer.elapsedSeconds() > 2) {return false;}
    	
		return true;
    }

    public static boolean testPart3(List<Integer> ad) {
        // Your code goes here
    	Stopwatch timer = new Stopwatch();
    	
    	for (int i = 0; i < 1000000; i++) {ad.add(i,i);}
    	
    	// test 1
    	timer.start();
    	ad.add(9,100);
    	timer.stop();    	
    	if (timer.elapsedSeconds() > 2) {return false;}
    	if (ad.get(9) != 100) {return false;}
    	
    	// test 2
    	timer.start();
    	ad.add(15,2000000);
    	timer.stop();    	
    	if (timer.elapsedSeconds() > 2) {return false;}
    	if (ad.get(15) != 1000) {return false;}
    	
    	return true;
    }

    public static boolean testPart5(List<Integer> ras) {
        // Your code goes here
    	Stopwatch timer = new Stopwatch();
    	
    	
    	for (int i = 0; i < 1000000; i++) {ras.add(i);}
    	
    	// test 1
    	timer.start();
    	ras.add(15,2000000);
    	timer.stop();    
    	if (timer.elapsedSeconds() > 2) {return false;}
    	if (ras.get(15) != 2000000) {return false;}
    	
    	return true;
    }
    
    public static void main(String[] args)
    {
    	BulkArrayDeque ad = new BulkArrayDeque<Integer>(Integer.class);
    	RandomQueue q = new RandomQueue();
    	ArrayDeque2 ad2 = new ArrayDeque2<Integer>(Integer.class);
    	RootishArrayStack2 ras = new RootishArrayStack2<Integer>(Integer.class);
    	
    	/*if (testPart1(q)) {System.out.println("Test Passed");}
    	else {System.out.println("Test Failed");}*/
    	
    	/*if (testPart2(ad)) {System.out.println("Test Passed");}
    	else {System.out.println("Test Failed");}*/
    	
    	/*if (testPart3(ad2)) {System.out.println("Test Passed");}
    	else {System.out.println("Test Failed");}*/
    	
    	if (testPart5(ras)) {System.out.println("Test Passed");}
    	else {System.out.println("Test Failed");}
    }
}

