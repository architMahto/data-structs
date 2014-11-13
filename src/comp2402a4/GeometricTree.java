package comp2402a4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GeometricTree extends BinaryTree<GeometricTreeNode> {

	public GeometricTree() {
		super (new GeometricTreeNode());
	}
	
	public void inorderDraw() {
		assignLevels();
		// TODO: use your code here instead
		//Random rand = new Random();
		//randomX(r, rand);
		GeometricTreeNode u = r, prev = nil, next;
		int xCounter = 0;
		while (u != nil) {
			if (prev == u.parent) {
				if (u.left != nil) {next = u.left;}
				else if (u.right != nil) {next = u.right;}
				else {
					u.position.x = xCounter;
					xCounter++;
					next = u.parent;
				}
			} else if (prev == u.left) {
				u.position.x = xCounter;
				xCounter++;
				if (u.right != nil) {
					next = u.right;
				} else {
					next = u.parent;
				}
			} else {
				next = u.parent;
			}
			prev = u;
			u = next;
		}
	}
	
	protected void assignX(GeometricTreeNode u) {
		if (u == null) return;
	}
	
	protected void randomX(GeometricTreeNode u, Random r) {
		if (u == null) return;
		u.position.x = r.nextInt(60);
		randomX(u.left, r);
		randomX(u.right, r);
	}
	
	
	/**
	 * Draw each node so that it's x-coordinate is as small
	 * as possible without intersecting any other node at the same level 
	 * the same as its parent's
	 */
	public void leftistDraw() {
		assignLevels();
		Queue<GeometricTreeNode> q = new LinkedList<GeometricTreeNode>();
		q.add(r);
		
		GeometricTreeNode prev = null;
		int xPos = 0;
		
		while (!q.isEmpty()) {
			GeometricTreeNode u = q.remove();
			
			if (u == r) xPos = 0;
			else if (u.position.y > prev.position.y) xPos = 0;
			else xPos++;
			
			if (u.left != nil) q.add(u.left);
			if (u.right != nil) q.add(u.right);
			
			u.position.x = xPos;
			prev = u;
		}
	}
	
	
	public void balancedDraw() {
		assignLevels();
		Random rand = new Random();
		randomX(r, rand);
	}
		
	protected void assignLevels() {
		assignLevels(r, 0);
	}
	
	protected void assignLevels(GeometricTreeNode u, int i) {
		if (u == null) return;
		u.position.y = i;
		assignLevels(u.left, i+1);
		assignLevels(u.right, i+1);
	}
	
	public static void main(String[] args) {
		GeometricTree t = new GeometricTree();
		galtonWatsonTree(t, 100);
		System.out.println(t);
		t.inorderDraw();
		System.out.println(t);
	}
	
}
