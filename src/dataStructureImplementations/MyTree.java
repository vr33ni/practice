package dataStructureImplementations;

import java.util.LinkedList;
import java.util.Queue;


public class MyTree {

	static class Node {
		int key;
		Node left, right;
		
		Node(int key) {
			this.key=key;
			this.left=null;
			this.right=null;
		}
	}
	
	static Node root;
	static Node temp=root;
	
	
	static void insert(Node temp, int key) {
		if (temp == null) {
			root = new Node(key);
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);
	}
	
	public static void main(String[]args) {
		
	}
}
