package sortingAlgorithms;

// merge sort algorithm implementation - divide and conquer
public class MergeSort {
	//recursively split the array into halves, then sort and merge
	public static void mergeSort(int arr[], int n) {
		if (n<2) {
			return;
		}
		int mid = n/2;
		int leftArray[] = new int[mid];
		int rightArray[] = new int[n-mid];
		for (int i = 0; i < mid; i++) {
			leftArray[i] =  arr[i];
		}
		for (int i = mid; i < n; i++) {
			rightArray[i-mid] = arr[i];
		}
		mergeSort(leftArray,mid);
		mergeSort(rightArray,n-mid);
		merge(arr, leftArray, rightArray, mid, n-mid);
		
	}
	
	public static void merge(int arr[], int leftArr[], int rightArr[], int start, int end) {
		int i = 0, j = 0, k = 0;
		while (i < start && j < end) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			}
			else {
				arr[k++] = rightArr[j++];
			}
		}
		while (i < start) {
			arr[k++] = leftArr[i++];
		}
		while (j < end) {
			arr[k++] = rightArr[j++];
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
		mergeSort(arr, arr.length);
		printArray(arr);
	}
}
