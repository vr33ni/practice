package stackOperations;

public class kStacksInOneArraySimple {

	static class FixedStack {
		int numOfStacks = 3;
		int stackCap;
		int[] values;
		int[] stackSizes;

		FixedStack(int stackSize) {
			this.stackCap = stackSize;
			values = new int[stackCap * numOfStacks];
			stackSizes = new int[numOfStacks];
		}

		void push(int item, int stackNum) {
			if (isFull(stackNum)) {
				System.out.println("Stack overflow");
				return;
			}
			stackSizes[stackNum]++;
			values[indexOfTop(stackNum)] = item;

			System.out.println("Stack elements total: " + values.length + " - top item of stackNum " + stackNum + " : "
					+ values[indexOfTop(stackNum)]);
		}

		int pop(int stackNum) {
			if (isEmpty(stackNum)) {
				System.out.println("Stack underflow");
			}
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex];
			values[topIndex] = 0;
			stackSizes[stackNum]--;
			return value;
		}

		// return top element of stack
		int peek(int stackNum) {
			if (isEmpty(stackNum)) {
				System.out.println("Stack underflow");
			}
			return values[indexOfTop(stackNum)];
		}

		boolean isEmpty(int stackNum) {
			return stackSizes[stackNum] == 0;
		}

		boolean isFull(int stackNum) {
			return stackSizes[stackNum] == stackCap;
		}

		int indexOfTop(int stackNum) {
			int offset = stackNum * stackCap;
			int size = stackSizes[stackNum];
			return offset * size - 1;
		}
	}

	public static void main(String[] args) {
		FixedStack myStack = new FixedStack(5);
		myStack.push(2, 1);

	}
}
