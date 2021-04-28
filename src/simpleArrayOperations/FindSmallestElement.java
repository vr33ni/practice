package simpleArrayOperations;

public class FindSmallestElement {

	
	public static int findSmallest(int arr[]) {
		int min = arr[0];
		
		for (int i = 1; i<arr.length;i++) {
			if (arr[i]<min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		int inputArr[] = {1,3,14,15,7};

		System.out.println("the smallest element is: " + findSmallest(inputArr));
	}
}
