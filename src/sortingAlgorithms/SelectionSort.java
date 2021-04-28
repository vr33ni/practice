package sortingAlgorithms;

//The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
public class SelectionSort {
	// selection sort algorithm implementation
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		//one by one, move the boundary of the unsorted array
		for (int i = 0; i < n-1; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			//swap the found min element with the first element
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

	

	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Main function
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Unsorted Array");
		printArray(arr);

		System.out.println("\nSorted array");
		selectionSort(arr);
		printArray(arr);
	}
}
