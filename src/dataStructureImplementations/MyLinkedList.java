package dataStructureImplementations;

import java.util.LinkedList;

public class MyLinkedList {

	static Node head; // head of the list

	static class Node {
		int data;
		Node next;

		Node(int d) { // constructor
			this.data = d;
			this.next = null;
		}
	}

	// insert new node at the beginning
	static void insertAtTheBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	// insert new node at the end
	static void insertAtTheEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = null;

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = newNode;
		return;
	}

	// insert new node after a given node
	static void insertAfterGivenNode(Node prev, int data) {
		if (prev == null)
			return;
		Node newNode = new Node(data);
		newNode.next = prev.next;
		prev.next = newNode;
	}

	// return item k to last
	static void returnKthToLast(Node head, int k) {
		if (head == null)
			return;
		Node curr = head;
		int pos = 0;
		while (curr != null) {
			if (pos >= k) {
				System.out.println("returning k to last " + curr.data);
			}
			pos++;
			curr = curr.next;
		}

	}

	// return item k - last using runner approach
	static void returnKthToLastUsingRunner(Node head, int k) {
		Node n1 = head;
		Node n2 = head;
		for (int i = 0; i < k; i++) {
			if (n1 == null) {
				return;
			}
			n1 = n1.next;
		}
		while (n1 != null) {
			n1 = n1.next;
			n2 = n2.next;

		}
		// n2 at position k now, n1 at end
		while (n2 != null) {
			System.out.println("node k to last " + n2.data); // at position k now
			n2 = n2.next;
		}

	}

	// used in isPalindrome
	static Node reverseAndClone(Node node) {
		Node head = null;
		while (node != null) {
			Node n = new Node(node.data);
			n.next = head;
			head = n;
			node = node.next;

		}
		return head;
	}

	// used in isPalindrome
	static boolean isEqual(Node one, Node two) {
		while (one != null && two != null) {
			if (one.data != two.data)
				return false;
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	// check if linked list is a palindrome
	static boolean isPalindrome(Node head) {
		Node reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	// print linked list
	static void print() {
		Node current = MyLinkedList.head;
		while (current != null) {
			System.out.println("Node: " + current.data);
			current = current.next;
		}
	}

	static Node search(int data) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == data) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	// delete a node if its not head or tail and with only access to this node
	// approach: copy data from the next node to given node and then point the given
	// node to the node after the next node
	static boolean deleteMiddleNode(Node someNode) {

		if (someNode == null || someNode.next == null) {
			return false;
		}
		Node next = someNode.next;
		someNode.data = next.data;
		someNode.next = next.next;
		return true;
	}
	
	

	//partition linked list into two lists around value x
	static void partition(Node node, int x) {
		Node head = node;
		Node tail = node;

		while (node != null) {
			Node next = node.next;
			if (node.data < x) {
				node.next = head;
				head = node;
				System.out.println("first part: " + head.data);
			} else {
				node.next = tail;
				tail = node;
				System.out.println("second part: " + tail.data);

			}
			node = next;
		}
		
		tail.next = null;
	}
	
	static Node containsLoop(Node head) {
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null) { //find meeting point (=loop size-k steps into the list)
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) { //error check => no meeting point therefre no loop
			return null;
		}
		slow=head; //move slow to head; keep fast at meeting point. each are k steps from loop start, if they move at the same speed, they must move at loop start
		while (slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return fast;
	}
	

	public static void main(String[] args) {
		MyLinkedList.insertAtTheBeginning(1);
		MyLinkedList.insertAtTheEnd(2);
		MyLinkedList.insertAtTheEnd(3);
		MyLinkedList.insertAtTheEnd(4);
		MyLinkedList.insertAtTheEnd(5);
		MyLinkedList.insertAtTheEnd(6);
		MyLinkedList.insertAtTheEnd(1);

//		Node myNode = MyLinkedList.search(123);
//		MyLinkedList.insertAfterGivenNode(myNode, 10);
		MyLinkedList.print();
//		MyLinkedList.returnKthToLast(head, 1);
//		MyLinkedList.returnKthToLastUsingRunner(head, 3);
//		System.out.println(MyLinkedList.isPalindrome(head));
		MyLinkedList.partition(head, 3);

	}
}
