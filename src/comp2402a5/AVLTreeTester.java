package comp2402a5;

import java.util.Set;
import java.util.TreeSet;

public class AVLTreeTester {
	
    public static boolean testAVLTree(AVLTree<Integer> t) {
        // Add your test code here.
        // This code should return true if t is a properly implemented AVLTree.
        // Otherwise, it should return false, crash, or take too long to execute
    	Set<Integer> ss = new TreeSet<Integer>();
    	long start, stop;
    	double elapsedSeconds;
    	int n = 100000;
    	
    	for (int i = 0; i < n; i++) {
    		int random = (int) Math.ceil(Math.random()*n);
    		start = System.nanoTime();
    		if (t.add(random) != ss.add(random)) return false;
    		stop = System.nanoTime();
    		elapsedSeconds = (stop - start) * 1e-9;
    		if (elapsedSeconds > 1 || elapsedSeconds > Math.log10(n)) 
    			return false;
    	}
    	
    	/**
    	 * TODO: Check if the height of the left child and right child 
    	 * of every node is balanced (difference(height(leftChild), height(rightChild)) !> 1)
    	 */
    	
    	try {t.checkHeights(t.r);} 
    	catch (Exception e) {return false;}
    	
    	return true;
    }
    
    public static void main(String[] args) {
    	AVLTree<Integer> t = new AVLTree<Integer>();
    	
    	if (testAVLTree(t)) System.out.println("\nTest Passed\n");
    	else System.out.println("\nTest Failed\n");
    }
}
