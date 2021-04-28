package linkedLists;

import java.util.List;

import linkedLists.FindKthNodeInLinkedList.Node;

public class RemoveTail {
	// A Linked List Node
	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	static Node findTail(Node head) {

		int length = 0;
		Node current = head;

		while (current != null) {
			length++;
			current = current.next;
		}

//		Node tail = head;
//		
//		while (tail != null) {
//			System.out.println(tail.data);
//
//			tail = tail.next;
//		}
//		return tail;

		Node fast = head;
		Node slow = head;
		int start = 1;

		while (fast.next != null) {
			fast = fast.next;
			start++;

			if (start > length) {
				slow = slow.next;
			}
		
		}
		return slow;
	}
	
	public static int[] rotateLeft(int d, int[] arr) {
	    // Write your code here
		for (int i = 0; i < d; i++) {
			int j, first;
			first = arr[0];
			for (j=0; j<arr.length-1; j++) {
				arr[j] = arr[j+1];
			}
			arr[arr.length-1] = first;
		}
		   for (int i = 0; i < arr.length; i++) {
	            System.out.println(arr[i]);
	       }
		   return arr;
		
		  
//	            int n = arr.length;
//	            int[] newArr = new int[n];
//	            int[] rotate = new int[d];
//	            int[] a = new int[n-d];
//	            for (int i=0; i<n; i++) {
//	            	while (i<d) {	               
//	                  rotate[i] = arr[i];  
//	                  i++;
//	                }
//	            	
//	            }
//	            for (int i=0; i<n-d; i++) {
//	                 for (int j=d; j<n; j++) {
//	                     a[i] = arr[j];
//	                     i++;
//	                 }
//	            }
//	            
//	            System.arraycopy(rotate, 0, newArr, n-d, rotate.length); 
//	            System.arraycopy(a, 0, newArr, 0, a.length);                
//	            
//	            for (int i = 0; i < newArr.length; i++) {
//	            System.out.println(newArr[i]);
//	            }
//	            return newArr;

	    

	}

	public static void main(String[] args) {
		// input keys
		int[] keys = { 1, 2, 3, 4, 5 };

		Node head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}

		Node node = findTail(head);

		if (node != null) {
			System.out.println("Last node is " + node.data);
		}
		
		rotateLeft(2, keys);
	}
}
