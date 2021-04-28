package sortingAlgorithms;

public class BubbleSortSwapCounter {
	// Complete the countSwaps function below.
	static void countSwaps(int[] a) {
		int counter = 0;
		int n = a.length;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					// System.out.println(counter);
					counter++;
				}
			}

		}
		System.out.println("Array is sorted in " + counter + " swaps.");

		  System.out.println("First Element: " + a[0]);

	        System.out.println("Last Element: " + a[n-1]);
	       
	}

	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Main function
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

// 		System.out.println("Unsorted Array");
// 		printArray(arr);

// 		System.out.println("\nSorted array");
		countSwaps(arr);
// 		printArray(arr);
	}

}
