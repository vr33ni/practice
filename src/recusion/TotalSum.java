package recusion;

public class TotalSum {

	//non-recursive for reference
	static int totalSum(int[] numbers) {

		int total = 0;
		for (int i = 0; i < numbers.length; i++) {
			total = total + numbers[i];
		}
		return total;
	}

	//recursive - 
	// O(n^2) time => call for every element of the array; array.slice takes linear time to return a copy of the array
	// O(n) space - number of stackframes until we hit the base case
	static int totalSumRecursive(int[] numbers) {

		if (numbers.length == 0) {
			return 0;
		}

		int[] rest = getSliceOfArray(numbers, 1, numbers.length);
		return numbers[0] + totalSumRecursive(rest);
	}

	
	//recursive - more efficient
	// O(n) time => instead of passing in a copy of the array recursively, just maintain a reference to the bounds of the array
	// O(n) space - number of stackframes until we hit the base case
	static int totalSumRecursiveEfficient(int[] numbers) {
		return totalSumRecursiveEfficient(numbers, 0);
	}
	
	static int totalSumRecursiveEfficient(int[] numbers, int index) {
		if (index == numbers.length) {
			return 0;
		}
		return numbers[index] + totalSumRecursiveEfficient(numbers, index+1);
	}
	
	// helper method
	public static int[] getSliceOfArray(int[] arr, int start, int end) {

		// Get the slice of the Array
		int[] slice = new int[end - start];

		// Copy elements of arr to slice
		for (int i = 0; i < slice.length; i++) {
			slice[i] = arr[start + i];
		}

		// return the slice
		return slice;
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 3, 6, 7 };
		System.out.println(totalSumRecursive(numbers));
	}
}
