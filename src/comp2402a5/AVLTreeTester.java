package comp2402a5;

public class AVLTreeTester {
    public static boolean testAVLTree(AVLTree<Integer> t) {
        // Add your test code here.
        // This code should return true if t is a properly implemented AVLTree.
        // Otherwise, it should return false, crash, or take too long to execute
    	for (int i = 0; i < 15; i++)
    		t.add(i+1);
    	
    	/**
    	 * TODO: Check if the height of the left child and right child 
    	 * of every node is balanced (difference(height(leftChild), height(rightChild)) !> 1)
    	 */
    	
    	/**
    	 * TODO: Check if the tree is a binary search tree 
    	 * (if the elements are sorted to the left and the right)
    	 */
    	return true;
    }
}
