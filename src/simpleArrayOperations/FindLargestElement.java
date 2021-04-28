package simpleArrayOperations;

public class FindLargestElement {
	
	static int findLargest(int arr[]) {	
		int max = arr[0];
		
		for (int i=1; i<arr.length; i++) {
			if (arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	

	public static void main(String[] args) {
		int inputArr[] = {3,2,10,4,23};

		System.out.println("The largest element is: " + findLargest(inputArr));
	}
}
