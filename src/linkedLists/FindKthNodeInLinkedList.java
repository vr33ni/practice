package linkedLists;


public class FindKthNodeInLinkedList {
	// A Linked List Node
	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	static Node findKth(Node head, int k) {
		int len = 0;
		Node temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len >= k) {
			temp = head;
			for (int i = 1; i < len - k + 1; i++)
				temp = temp.next;
		}
		
		return temp;
	}

	
	
	public static void main(String[] args) {
		// input keys
		int[] keys = { 1, 2, 3, 4, 5 };

		Node head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}

		int k = 3;
		Node node = findKth(head, k);

		if (node != null) {
			System.out.println("k'th node from the end is " + node.data);
		}
	}
}
