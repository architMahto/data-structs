package comp2402a4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class GeometricTree extends BinaryTree<GeometricTreeNode> {

	public GeometricTree() {
		super (new GeometricTreeNode());
	}
	
	public void inorderDraw() {
		assignLevels();
		// TODO: use your code here instead
		GeometricTreeNode u = r, prev = nil, next;
		int xCounter = 0;
		while (u != nil) {
			if (prev == u.parent) {
				if (u.left != nil) {next = u.left;}
				else if (u.right != nil) {
					u.position.x = xCounter;
					xCounter++;
					next = u.right;
				} else {
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
		//Random rand = new Random();
		//randomX(r, rand);
		Map<GeometricTreeNode,Integer> tree = new HashMap<>();
		GeometricTreeNode u = r, prev = nil, next, left, right;
		u.position.x = 0; u.position.y = 0;
		int x = 0, power = 0;
		
		while (u != nil) {
			
			left = u.left;
			right = u.right;
			
			if (prev == u.parent) {
				if (u.left != nil) { 
					next = u.left;
				} else if (u.right != nil) {
					next = u.right;
				} else {
					next = u.parent;
					tree.put(u, 1);
				}
			} else if (prev == u.left) {
				if (u.right != nil) {
					next = u.right;
				} else {
					next = u.parent;
					tree.put(u, 1 + tree.get(u.left));
				}
			} else {
				next = u.parent;
				if (tree.get(u.left) == null)
					tree.put(u, 1 + tree.get(u.right));
				else 
					tree.put(u, 1 + tree.get(u.left) + tree.get(u.right));
			}
			
			prev = u;
			u = next;
			
			if (next == left) {
				u.position.x += Math.pow(2.0,power);
			} else if (next == right) {
				u.position.x += Math.pow(3.0,power);
			}
		}
		
		u = r; prev = nil;
		u.position.x = 0; u.position.y = 0;
		
		while (u != nil) {
			if (prev == u.parent) {
				if (u.left != nil) {
					if (u.right != nil) {
						if (tree.get(u.left) <= tree.get(u.right)) next = u.left;
						else next = u.right;		
					} else {
						next = u.left;
					}
				} else if (u.right != nil) {
					if (u.left != nil) {
						if (tree.get(u.right) <= tree.get(u.left)) next = u.right;
						else next = u.left;		
					} else {
						next = u.right;
					}
				} else {
					next = u.parent;
				}
			} else if (prev == u.left) {
				if (u.right != nil) next = u.right;
				else next = u.parent;
			} else {
				if (tree.get(u.left) > tree.get(u.right)) next = u.left; 
				else next = u.parent;
			}
							
			prev = u;
			u = next;
			
			//iterations++;
			//if (iterations >= 10) break;
		}
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
