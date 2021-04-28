package stackOperations;

public class kStacksInOneArray {

	static class KStack {
		int arr[]; // array of size n to store the actual content to be stored in stacks
		int top[]; // array of size k to store indices of top elements of stacks
		int next[]; // array of size n to store next entry in all stacks
					// pointer to the next element in the stack
					// helping to find the next available free spot

		int n, k;
		int free; // to store the beginning index of free list

		KStack(int k, int n) {
			// initialize n and k and allocate memory for all arrays
			this.k = k;
			this.n = n;
			arr = new int[n];
			top = new int[k];
			next = new int[n];

			// initialize all stacks as empty
			for (int i = 0; i < k; i++) {
				top[i] = -1;
			}

			free = 0; // next free spot available - intially 0

			for (int i = 0; i < n - 1; i++) {
				next[i] = i + 1;
			}
			next[n - 1] = -1;
		}

		void push(int item, int stackNum) {
			if (isFull()) { //overflow check
				System.out.println("Stack overflow");
				return;
			}
			int i = free; // store index of first free slot (where item will be stored);
			
			free = next[i]; // update index of free slot to index of next slot in free list
			
			next[i] = top[stackNum]; //update next of top and then top for stacknumber "stackNum"
			top[stackNum] = i;
			
			arr[i] = item; //put item in to the array
		}

		int pop(int stackNum) {
			if (isEmpty(stackNum)) {
				System.out.println("Stack underflow");
				return Integer.MAX_VALUE;
			}
			int i = top[stackNum]; // find index of top item in stack number "stackNum"
			top[stackNum] = next[i]; // change top to store next of previous top

			// attach previous top to the beginning of free list
			next[i] = free;
			free = i;

			// return previous top item
			return arr[i];

		}

		boolean isEmpty(int stackNum) {
			return (top[stackNum] == -1);
		}
		
		boolean isFull() {
			return free == -1;
		}
	}

	public static void main(String[] args) {

		int k = 3;
		int n = 10;
		KStack kStack = new KStack(k, n);

	}
}
